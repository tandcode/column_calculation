package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.ShapedSection;

import java.util.List;

public interface SectionRepository  extends CrudRepository<ShapedSection, Integer> {
    List<ShapedSection> findByStandardAndProfileNumber(String standard, String profileNumber);
    List<ShapedSection> findAll();
}
