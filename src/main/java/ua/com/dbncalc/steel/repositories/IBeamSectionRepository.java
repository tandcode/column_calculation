package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.IBeamSection;
import ua.com.dbncalc.steel.models.sections.ShapedSection;

import java.util.List;
import java.util.Optional;

public interface IBeamSectionRepository extends CrudRepository<IBeamSection, Integer> {
    Optional<IBeamSection> findByStandardAndProfileNumber(String standard, String profileNumber);
}
