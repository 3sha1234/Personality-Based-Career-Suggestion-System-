import com.careerapp.model.*;
import com.careerapp.service.PersonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.careerapp.repository.UserRepository;

import java.util.List;
import java.util.Map;

// ======= QUESTIONS CONTROLLER =======
@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
class QuestionController {

    @Autowired
    private PersonalityService personalityService;

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestions() {
        return ResponseEntity.ok(personalityService.getAllActiveQuestions());
}
    
}

// ======= TEST SUBMISSION CONTROLLER =======
@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
class TestController {

    @Autowired
    private PersonalityService personalityService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/submit")
    public ResponseEntity<?> submitTest(
            @RequestBody Map<String, Object> request,
            Authentication authentication) {
        try {
            String username = authentication.getName();
            Long userId = userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User not found"))
                    .getId();

            // Parse answers: questionId -> answerId
            @SuppressWarnings("unchecked")
            Map<String, Object> rawAnswers = (Map<String, Object>) request.get("answers");
            Map<Long, Long> answers = new java.util.HashMap<>();
            rawAnswers.forEach((k, v) -> answers.put(Long.parseLong(k), Long.parseLong(v.toString())));

            Map<String, Object> result = personalityService.calculateAndSaveScore(userId, answers);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(Authentication authentication) {
        String username = authentication.getName();
        Long userId = userRepository.findByUsername(username)
                .orElseThrow().getId();
        return ResponseEntity.ok(personalityService.getScoreHistory(userId));
    }

    @GetMapping("/latest")
    public ResponseEntity<?> getLatest(Authentication authentication) {
        String username = authentication.getName();
        Long userId = userRepository.findByUsername(username)
                .orElseThrow().getId();
        return personalityService.getLatestScore(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

// ======= CAREERS CONTROLLER =======
@RestController
@RequestMapping("/api/careers")
@CrossOrigin(origins = "*")
class CareerController {

    @Autowired
    private PersonalityService personalityService;

    @Autowired
    private com.careerapp.repository.CareerRepository careerRepository;

    @GetMapping
    public ResponseEntity<?> getAllCareers() {
        return ResponseEntity.ok(careerRepository.findByActiveTrue());
    }

    @GetMapping("/by-personality/{type}")
    public ResponseEntity<?> getByPersonality(@PathVariable String type) {
        try {
            return ResponseEntity.ok(personalityService.getCareersByPersonality(type));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid personality type"));
        }
    }
}
