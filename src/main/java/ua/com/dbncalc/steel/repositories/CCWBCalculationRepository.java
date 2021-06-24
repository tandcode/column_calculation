package ua.com.dbncalc.steel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.dbncalc.steel.models.CCWBCalculation;
import ua.com.dbncalc.steel.models.CCWBInput;
import ua.com.dbncalc.steel.models.User;

import java.util.List;
import java.util.Optional;

public interface CCWBCalculationRepository extends JpaRepository<CCWBCalculation, Long> {
    List<CCWBCalculation> findByUser(User user);
    List<CCWBCalculation> findByUserAndInput_IsSaved(User user, Boolean isSaved);
    List<CCWBCalculation> findTop10ByOrderByCreationDateTime();

    Optional<CCWBCalculation> findByInput(CCWBInput input);
}
