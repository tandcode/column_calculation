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
import ua.com.dbncalc.steel.services.SectionService;
import ua.com.dbncalc.steel.services.util.ColComprWithBuckCalcUnit;

@Controller
public class ColComprWithBuckController {

    @Autowired
    private ColComprWithBuckInputDao inputDao;

    @Autowired
    private ColComprWithBuckService service;

    @Autowired
    private SteelRepository steelResistRepository;

    @Autowired
    private SectionService sectionService;

    @GetMapping("/col")
    public String columnCompressionWithBucklingForm(Model model) {
        model.addAttribute("colComprWithBuckDto", new ColComprWithBuckDto());
        model.addAttribute("sections", sectionService.getProfileNumbers());
        model.addAttribute("result", null);
        model.addAttribute("sectionNumber", null);
        return "colCalc";
    }

    @PostMapping("/col")
    public String columnCompressionWithBucklingPostForm(
            Model model,
            @ModelAttribute ColComprWithBuckDto colComprWithBuckDto
    )
    {
        inputDao.create(colComprWithBuckDto);
        model.addAttribute("sections", sectionService.getProfileNumbers());

        ColComprWithBuckCalcUnit result = service.calculate(colComprWithBuckDto);
        model.addAttribute("result", result);
        model.addAttribute("sectionNumber", result.getInput().getSectionNumber());
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
