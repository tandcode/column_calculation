package ua.com.dbncalc.steel.dao;

import org.springframework.stereotype.Component;
import ua.com.dbncalc.steel.models.ColComprWithBuckInput;

import java.util.ArrayList;
import java.util.List;

@Component
public class ColComprWithBuckInputDao {
    private static int INPUTS_COUNT;
    private List<ColComprWithBuckInput> inputList;
    {
        inputList = new ArrayList<>();
    }
    public void create(ColComprWithBuckInput input){
        input.setId(++INPUTS_COUNT);
        inputList.add(input);
    }

}
