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

import java.util.List;

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
        ColComprWithBuckService service = new ColComprWithBuckService(colComprWithBuckInput, i_profileGost8239_89Repository);
        model.addAttribute("colComprWithBuckService", service);
        return "result.html";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<I_ProfileGost8239_89> getAll() {
        return i_profileGost8239_89Repository.findAll();
    }

    @GetMapping("/all/{profile}")
    public @ResponseBody I_ProfileGost8239_89 getProfileByName(@PathVariable String profile) {

        List<I_ProfileGost8239_89> result = i_profileGost8239_89Repository.findI_ProfileGost8239_89ByProfileNumber(profile);
        return result.size() > 0 ? result.get(0) : null;
    }
}
