package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.I_ProfileGost8239_89;

import java.util.List;

public interface I_ProfileGost8239_89Repository extends CrudRepository<I_ProfileGost8239_89, Integer> {
    List<I_ProfileGost8239_89> findI_ProfileGost8239_89ByProfileNumber(String profileNumber);
}
