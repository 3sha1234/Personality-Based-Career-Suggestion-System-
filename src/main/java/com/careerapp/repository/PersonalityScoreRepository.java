import com.careerapp.model.PersonalityScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalityScoreRepository extends JpaRepository<PersonalityScore, Long> {
    List<PersonalityScore> findByUserIdOrderByTakenAtDesc(Long userId);
    Optional<PersonalityScore> findTopByUserIdOrderByTakenAtDesc(Long userId);
}
