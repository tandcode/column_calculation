package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.steels.Steel;

import java.util.List;

public interface SteelRepository extends CrudRepository<Steel, Integer> {
    List<Steel> findBySteelName(String steelName);
}
