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

    public CCWBCalculationWorker calculate(CCWBInput input){
        ccwbCalculationWorker.calculate(input);
        return ccwbCalculationWorker;
    }

    public CCWBCalculation createCalculation(CCWBCalculationWorker ccwbCalculationWorker, User user) {
        List<CCWBCalculation> tenRecentCalculations = ccwbCalculationRepository.findTop10ByUserOrderByCreationDateTime(user);
        if(tenRecentCalculations.size() == 10){
            Optional<CCWBCalculation> oldestUnsavedCalc = Optional.ofNullable(tenRecentCalculations.stream()
                    .filter(ccwbCalculation -> !ccwbCalculation.getInput().getIsSaved())
                    .findFirst()
                    .orElse(null));
            if(oldestUnsavedCalc.isPresent()) ccwbCalculationRepository.deleteById(oldestUnsavedCalc.get().getId());
        }

        return ccwbCalculationRepository.save(
                CCWBCalculation.builder()
                .input(ccwbInputRepository.save(ccwbCalculationWorker.getInput()))
                .result(ccwbResultRepository.save(
                        CCWBResult.builder()
                        .axialComressionRes(ccwbCalculationWorker.getColComprWithBuckModulusY()
                                .getValue().doubleValue())
                        .build()
                        )
                )
                .user(user)
                .build()
        );
    }

    public CCWBCalculation saveCalculation(CCWBInput input) {
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
