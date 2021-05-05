package ua.com.dbncalc.steel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.dbncalc.steel.dto.ColComprWithBuckDto;
import ua.com.dbncalc.steel.services.util.ColComprWithBuckCalcUnit;

@Service
public class ColComprWithBuckService {
    @Autowired
    ColComprWithBuckCalcUnit colComprWithBuckCalcUnit;

    public ColComprWithBuckCalcUnit calculate(ColComprWithBuckDto input){
        colComprWithBuckCalcUnit.calculate(input);
        return colComprWithBuckCalcUnit;
    }
}
