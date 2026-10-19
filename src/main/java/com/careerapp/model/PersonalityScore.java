import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "personality_scores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalityScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer analyticalScore;

    @Column(nullable = false)
    private Integer creativeScore;

    @Column(nullable = false)
    private Integer socialScore;

    @Column(nullable = false)
    private Integer leadershipScore;

    @Column(nullable = false)
    private Integer practicalScore;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Answer.PersonalityCategory dominantPersonality;

    @Column(name = "taken_at")
    @Builder.Default
    private LocalDateTime takenAt = LocalDateTime.now();
}
