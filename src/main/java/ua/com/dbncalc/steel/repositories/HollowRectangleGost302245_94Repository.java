package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.HollowRectangleSection;
import ua.com.dbncalc.steel.models.sections.UProfileSection;

public interface HollowRectangleGost302245_94Repository
        extends CrudRepository<HollowRectangleSection, Integer> {
}