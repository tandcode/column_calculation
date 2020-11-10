package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.ShapedIBeamSection;

public interface IProfileGost19425_75Repository extends CrudRepository<ShapedIBeamSection, Integer> {
}
