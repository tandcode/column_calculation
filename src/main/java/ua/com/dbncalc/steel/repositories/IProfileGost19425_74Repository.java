package ua.com.dbncalc.steel.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.com.dbncalc.steel.models.sections.IProfileGost19425_74;

import java.util.List;

public interface IProfileGost19425_74Repository extends CrudRepository<IProfileGost19425_74, Integer> {
    List<IProfileGost19425_74> findByProfileNumber(String profileNumber);
}
