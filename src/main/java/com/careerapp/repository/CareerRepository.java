import com.careerapp.model.Answer.PersonalityCategory;
import com.careerapp.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findByPersonalityTypeAndActiveTrue(PersonalityCategory personalityType);
    List<Career> findByActiveTrue();
}
