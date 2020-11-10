package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.ShapedIBeamSection;
import ua.com.dbncalc.steel.models.sections.UProfileSection;

public interface UProfileGost8240_89ParallelFlangeRepository extends CrudRepository<UProfileSection, Integer> {
}
