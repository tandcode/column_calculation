package ua.com.dbncalc.steel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dbncalc.steel.models.CCWBCalculation;
import ua.com.dbncalc.steel.models.CCWBInput;
import ua.com.dbncalc.steel.models.CCWBResult;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.CCWBCalculationRepository;
import ua.com.dbncalc.steel.repositories.CCWBInputRepository;
import ua.com.dbncalc.steel.repositories.CCWBResultRepository;
import ua.com.dbncalc.steel.services.exceptions.SteelDoesntExistsException;
import ua.com.dbncalc.steel.services.util.CCWBCalculationWorker;

import java.util.List;
import java.util.Optional;

@Service
public class CCWBCalculationService {
    @Autowired
    CCWBCalculationWorker ccwbCalculationWorker;

    @Autowired
    CCWBCalculationRepository ccwbCalculationRepository;

    @Autowired
    CCWBInputRepository ccwbInputRepository;

    @Autowired
    CCWBResultRepository ccwbResultRepository;

    public CCWBCalculation createCalculation(CCWBInput input, User user) throws SteelDoesntExistsException {
        CCWBCalculation ccwbCalculation = ccwbCalculationWorker.calculate(input, user);
        List<CCWBCalculation> tenRecentCalculations = ccwbCalculationRepository
                .findTop10ByUserOrderByCreationDateTime(user);
        if(tenRecentCalculations.size() == 10){
            Optional<CCWBCalculation> oldestUnsavedCalc = tenRecentCalculations.stream()
                    .filter(ccwbCalc -> !ccwbCalc.getInput().getIsSaved())
                    .findFirst();
            oldestUnsavedCalc.ifPresent(ccwbCalc -> ccwbCalculationRepository.deleteById(ccwbCalc.getId()));
        }

        return ccwbCalculationRepository.save(ccwbCalculation);
    }

    public CCWBCalculation saveCalculationToSaved(CCWBInput input) {
        input.setIsSaved(true);
        ccwbInputRepository.save(input);
        return ccwbCalculationRepository.findByInput(input).orElseThrow();
    }

    public List<CCWBCalculation> getUserCalculations(User user) {
        return ccwbCalculationRepository.findByUser(user);
    }

    public List<CCWBCalculation> getSavedUserCalculations(User user) {
        return ccwbCalculationRepository.findByUserAndInput_IsSaved(user, true);
    }

    public CCWBInput findCCWBInput(Long id) {
        return ccwbInputRepository.findById(id).orElseThrow();
    }
}
