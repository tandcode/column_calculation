package ua.com.dbncalc.steel.dao;

import org.springframework.stereotype.Component;
import ua.com.dbncalc.steel.dto.ColComprWithBuckDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColComprWithBuckInputDao {
    private static int INPUTS_COUNT;
    private List<ColComprWithBuckDto> inputList;
    {
        inputList = new ArrayList<>();
    }
    public void create(ColComprWithBuckDto input){
        input.setId(++INPUTS_COUNT);
        inputList.add(input);
    }

}
