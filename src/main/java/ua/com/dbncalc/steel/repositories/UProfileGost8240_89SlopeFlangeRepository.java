package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.UProfileGost8240_89SlopeFlange;

import java.util.List;

public interface UProfileGost8240_89SlopeFlangeRepository extends CrudRepository<UProfileGost8240_89SlopeFlange, Integer> {
    List<UProfileGost8240_89SlopeFlange> findByProfileNumber(String profileNumber);
}