import com.careerapp.model.*;
import com.careerapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonalityScoreRepository scoreRepository;

    // ===== QUESTION MANAGEMENT =====

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(questionRepository.findAll());
    }

    @PostMapping("/questions")
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(questionRepository.save(question));
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long id, @RequestBody Question updated) {
        return questionRepository.findById(id).map(q -> {
            q.setQuestionText(updated.getQuestionText());
            q.setOrderIndex(updated.getOrderIndex());
            q.setActive(updated.getActive());
            return ResponseEntity.ok(questionRepository.save(q));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        questionRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Deleted"));
    }

    // ===== CAREER MANAGEMENT =====

    @GetMapping("/careers")
    public ResponseEntity<List<Career>> getAllCareers() {
        return ResponseEntity.ok(careerRepository.findAll());
    }

    @PostMapping("/careers")
    public ResponseEntity<?> createCareer(@RequestBody Career career) {
        return ResponseEntity.ok(careerRepository.save(career));
    }

    @PutMapping("/careers/{id}")
    public ResponseEntity<?> updateCareer(@PathVariable Long id, @RequestBody Career updated) {
        return careerRepository.findById(id).map(c -> {
            c.setTitle(updated.getTitle());
            c.setDescription(updated.getDescription());
            c.setPersonalityType(updated.getPersonalityType());
            c.setSkillsRequired(updated.getSkillsRequired());
            c.setAverageSalary(updated.getAverageSalary());
            c.setJobOutlook(updated.getJobOutlook());
            c.setEducationRequired(updated.getEducationRequired());
            c.setDayInLife(updated.getDayInLife());
            c.setActive(updated.getActive());
            return ResponseEntity.ok(careerRepository.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/careers/{id}")
    public ResponseEntity<?> deleteCareer(@PathVariable Long id) {
        careerRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Deleted"));
    }

    // ===== DASHBOARD STATS =====

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        long totalUsers = userRepository.count();
        long totalTests = scoreRepository.count();
        long totalCareers = careerRepository.count();
        long totalQuestions = questionRepository.count();

        return ResponseEntity.ok(Map.of(
                "totalUsers", totalUsers,
                "totalTests", totalTests,
                "totalCareers", totalCareers,
                "totalQuestions", totalQuestions
        ));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
