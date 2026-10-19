import jakarta.persistence.*;
import lombok.*;

import lombok.Data;

@Entity
@Table(name = "careers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Answer.PersonalityCategory personalityType;

    @Column(columnDefinition = "TEXT")
    private String skillsRequired;

    @Column(length = 100)
    private String averageSalary;

    @Column(length = 100)
    private String jobOutlook;

    @Column(columnDefinition = "TEXT")
    private String educationRequired;

    @Column(columnDefinition = "TEXT")
    private String dayInLife;

    @Column(nullable = false)
    @Builder.Default
    private Boolean active = true;
}
