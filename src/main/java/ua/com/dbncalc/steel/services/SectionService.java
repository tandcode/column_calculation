package ua.com.dbncalc.steel.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dbncalc.steel.dto.SectionDTO;
import ua.com.dbncalc.steel.repositories.SectionRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SectionService {
    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    ModelMapper modelMapper;

    public Map<String, List<String>> getProfileNumbers() {
        return sectionRepository.findAll().stream()
                .map(section -> modelMapper.map(section, SectionDTO.class))
                .collect(Collectors.groupingBy(SectionDTO::getStandard,
                        Collectors.mapping(SectionDTO::getProfileNumber, Collectors.toList())));
    }
}
