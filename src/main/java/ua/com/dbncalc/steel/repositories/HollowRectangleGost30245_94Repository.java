package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.HollowRectangleGost30245_94;

import java.util.List;

public interface HollowRectangleGost30245_94Repository extends CrudRepository<HollowRectangleGost30245_94, Integer> {
    List<HollowRectangleGost30245_94> findByProfileNumber(String profileNumber);
}