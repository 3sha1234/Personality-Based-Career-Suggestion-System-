import com.careerapp.model.*;
import com.careerapp.model.Answer.PersonalityCategory;
import com.careerapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonalityService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private PersonalityScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Question> getAllActiveQuestions() {
        return questionRepository.findAll();
}

    /**
     * Core Score Calculation Algorithm:
     * - User submits answerId per question
     * - Each answer has a PersonalityCategory + points
     * - We sum points per category
     * - Dominant category = max score
     */
    public Map<String, Object> calculateAndSaveScore(Long userId, Map<Long, Long> questionAnswerMap) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Question> questions = questionRepository.findAll();

        // Score buckets
        Map<PersonalityCategory, Integer> scores = new EnumMap<>(PersonalityCategory.class);
        for (PersonalityCategory cat : PersonalityCategory.values()) {
            scores.put(cat, 0);
        }

        // Accumulate scores from selected answers
        for (Question question : questions) {
            Long selectedAnswerId = questionAnswerMap.get(question.getId());
            if (selectedAnswerId == null) continue;

            question.getAnswers().stream()
                    .filter(a -> a.getId().equals(selectedAnswerId))
                    .findFirst()
                    .ifPresent(answer -> {
                        scores.merge(answer.getCategory(), answer.getPoints(), Integer::sum);
                    });
        }

        // Determine dominant personality
        PersonalityCategory dominant = scores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(PersonalityCategory.ANALYTICAL);

        // Save score
        PersonalityScore score = PersonalityScore.builder()
                .user(user)
                .analyticalScore(scores.get(PersonalityCategory.ANALYTICAL))
                .creativeScore(scores.get(PersonalityCategory.CREATIVE))
                .socialScore(scores.get(PersonalityCategory.SOCIAL))
                .leadershipScore(scores.get(PersonalityCategory.LEADERSHIP))
                .practicalScore(scores.get(PersonalityCategory.PRACTICAL))
                .dominantPersonality(dominant)
                .build();
        scoreRepository.save(score);

        // Fetch matching careers
        List<Career> careers = careerRepository.findByPersonalityTypeAndActiveTrue(dominant);

        // Build result
        Map<String, Object> result = new HashMap<>();
        result.put("analyticalScore", scores.get(PersonalityCategory.ANALYTICAL));
        result.put("creativeScore", scores.get(PersonalityCategory.CREATIVE));
        result.put("socialScore", scores.get(PersonalityCategory.SOCIAL));
        result.put("leadershipScore", scores.get(PersonalityCategory.LEADERSHIP));
        result.put("practicalScore", scores.get(PersonalityCategory.PRACTICAL));
        result.put("dominantPersonality", dominant.name());
        result.put("careers", careers.stream().map(this::careerToMap).toList());

        return result;
    }

    public List<Map<String, Object>> getCareersByPersonality(String personality) {
        PersonalityCategory cat = PersonalityCategory.valueOf(personality.toUpperCase());
        return careerRepository.findByPersonalityTypeAndActiveTrue(cat)
                .stream().map(this::careerToMap).toList();
    }

    public Optional<PersonalityScore> getLatestScore(Long userId) {
        return scoreRepository.findTopByUserIdOrderByTakenAtDesc(userId);
    }

    public List<PersonalityScore> getScoreHistory(Long userId) {
        return scoreRepository.findByUserIdOrderByTakenAtDesc(userId);
    }

    private Map<String, Object> careerToMap(Career career) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", career.getId());
        map.put("title", career.getTitle());
        map.put("description", career.getDescription());
        map.put("personalityType", career.getPersonalityType().name());
        map.put("skillsRequired", career.getSkillsRequired() != null
                ? Arrays.asList(career.getSkillsRequired().split(","))
                : List.of());
        map.put("averageSalary", career.getAverageSalary());
        map.put("jobOutlook", career.getJobOutlook());
        map.put("educationRequired", career.getEducationRequired());
        map.put("dayInLife", career.getDayInLife());
        return map;
    }
}
