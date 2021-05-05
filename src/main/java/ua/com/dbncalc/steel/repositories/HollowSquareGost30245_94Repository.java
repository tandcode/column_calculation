package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.HollowSquareGost30245_94;

import java.util.List;

public interface HollowSquareGost30245_94Repository extends CrudRepository<HollowSquareGost30245_94, Integer> {
    List<HollowSquareGost30245_94> findByProfileNumber(String profileNumber);
}