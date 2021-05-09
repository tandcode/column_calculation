package ua.com.dbncalc.steel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.dbncalc.steel.dao.ColComprWithBuckInputDao;
import ua.com.dbncalc.steel.dto.ColComprWithBuckDto;
import ua.com.dbncalc.steel.models.steels.Steel;
import ua.com.dbncalc.steel.repositories.SteelRepository;
import ua.com.dbncalc.steel.services.ColComprWithBuckService;

@Controller
public class ColComprWithBuckController {

    @Autowired
    private ColComprWithBuckInputDao inputDao;

    @Autowired
    private ColComprWithBuckService service;

    @Autowired
    private SteelRepository steelResistRepository;


    @GetMapping("/col")
    public String columnCompressionWithBucklingForm(Model model) {
        model.addAttribute("colComprWithBuckDto", new ColComprWithBuckDto());
        model.addAttribute("result", null);
        return "colCalc";
    }

    @PostMapping("/col")
    public String columnCompressionWithBucklingPostForm(
            Model model,
            @ModelAttribute ColComprWithBuckDto colComprWithBuckDto
    )
    {
        inputDao.create(colComprWithBuckDto);
        model.addAttribute("result", service.calculate(colComprWithBuckDto));
        return "colCalc";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Steel> getAll() {
        return steelResistRepository.findAll();
    }
//
//    @GetMapping("/all/{profile}")
//    public @ResponseBody I_ProfileGost8239_89 getProfileByName(@PathVariable String profile) {
//
//        List<I_ProfileGost8239_89> result = i_profileGost8239_89Repository.findI_ProfileGost8239_89ByProfileNumber(profile);
//        return result.size() > 0 ? result.get(0) : null;
//    }
}
