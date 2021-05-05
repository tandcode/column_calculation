package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.UProfileGost8240_89ParallelFlange;

import java.util.List;

public interface UProfileGost8240_89ParallelFlangeRepository extends CrudRepository<UProfileGost8240_89ParallelFlange, Integer> {
    List<UProfileGost8240_89ParallelFlange> findByProfileNumber(String profileNumber);
}