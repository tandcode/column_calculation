package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.IProfileGost8239_89;

import java.util.List;

public interface IProfileGost8239_89Repository extends CrudRepository<IProfileGost8239_89, Integer> {
    List<IProfileGost8239_89> findByProfileNumber(String profileNumber);
}
