package ua.com.dbncalc.steel.dao;

import org.springframework.stereotype.Component;
import ua.com.dbncalc.steel.models.CCWBInput;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColComprWithBuckInputDao {
    private static Long INPUTS_COUNT;
    private List<CCWBInput> inputList;
    {
        inputList = new ArrayList<>();
    }
    public void create(CCWBInput input){
        input.setId(++INPUTS_COUNT);
        inputList.add(input);
    }

}
