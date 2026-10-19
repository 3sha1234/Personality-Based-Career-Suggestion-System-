import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Question question;

    @Column(nullable = false, length = 255)
    private String answerText;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonalityCategory category;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private Integer orderIndex;

    public enum PersonalityCategory {
        ANALYTICAL, CREATIVE, SOCIAL, LEADERSHIP, PRACTICAL
    }
}
