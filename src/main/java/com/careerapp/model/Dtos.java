import lombok.Data;
import jakarta.validation.constraints.*;

// ======= AUTH DTOs =======

@Data
class RegisterRequest {
    @NotBlank @Size(min = 3, max = 50)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 6)
    private String password;
    private String fullName;
}

@Data
class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

@Data
class AuthResponse {
    private String token;
    private String username;
    private String email;
    private String role;
    private Long userId;

    public AuthResponse(String token, String username, String email, String role, Long userId) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.role = role;
        this.userId = userId;
    }
}

// ======= TEST DTOs =======

@Data
class TestSubmissionRequest {
    @NotNull
    private java.util.Map<Long, Long> answers; // questionId -> answerId
}

@Data
class ScoreResponse {
    private Integer analyticalScore;
    private Integer creativeScore;
    private Integer socialScore;
    private Integer leadershipScore;
    private Integer practicalScore;
    private String dominantPersonality;
    private java.util.List<CareerResponse> suggestedCareers;
}

@Data
class CareerResponse {
    private Long id;
    private String title;
    private String description;
    private String personalityType;
    private java.util.List<String> skillsRequired;
    private String averageSalary;
    private String jobOutlook;
    private String educationRequired;
    private String dayInLife;
}
