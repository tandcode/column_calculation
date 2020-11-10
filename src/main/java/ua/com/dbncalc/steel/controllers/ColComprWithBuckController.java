package ua.com.dbncalc.steel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.dbncalc.steel.dao.ColComprWithBuckInputDao;
import ua.com.dbncalc.steel.models.ColComprWithBuckInput;
import ua.com.dbncalc.steel.models.sections.I_ProfileGost8239_89;
import ua.com.dbncalc.steel.repositories.I_ProfileGost8239_89Repository;
import ua.com.dbncalc.steel.services.ColComprWithBuckService;

@Controller
public class ColComprWithBuckController {


    @Autowired
    private ColComprWithBuckInputDao inputDao;

    @Autowired
    private I_ProfileGost8239_89Repository i_profileGost8239_89Repository;

    @GetMapping("/col")
    public String columnCompressionWithBucklingForm(@ModelAttribute("colComprWithBuckInput")
                                                    ColComprWithBuckInput colComprWithBuckInput) {
//        model.addAttribute("colComprWithBuckInput", new ColComprWithBuckInput());
        return "index";
    }

    @PostMapping("/col")
    public String columnCompressionWithBucklingPostForm(
            @ModelAttribute ("colComprWithBuckInput")ColComprWithBuckInput colComprWithBuckInput,
            Model model
    )
    {
        inputDao.create(colComprWithBuckInput);
        ColComprWithBuckService service = new ColComprWithBuckService(colComprWithBuckInput);
        model.addAttribute("colComprWithBuckService", service);
        return "result";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<I_ProfileGost8239_89> getAll() {
        return i_profileGost8239_89Repository.findAll();
    }
}
