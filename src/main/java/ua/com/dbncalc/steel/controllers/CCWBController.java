package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.com.dbncalc.steel.models.CCWBCalculation;
import ua.com.dbncalc.steel.models.CCWBInput;
import ua.com.dbncalc.steel.services.CCWBCalculationService;
import ua.com.dbncalc.steel.services.SectionService;
import ua.com.dbncalc.steel.services.UserService;
import ua.com.dbncalc.steel.services.exceptions.SteelDoesntExistsException;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/axial-force-calculation")
@Slf4j
public class CCWBController {

    @Autowired
    private UserService userService;

    @Autowired
    private CCWBCalculationService ccwbCalculationService;

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public String axialCompressionOrTension(Model model) {
        model.addAttribute("ccwbInput", new CCWBInput());
        model.addAttribute("sections", sectionService.getProfileNumbers());
        model.addAttribute("result", null);
        model.addAttribute("sectionNumber", null);

        return "axial_force_calc";
    }

    @PostMapping
    public String axialCompressionOrTensionPost(
            @Valid @ModelAttribute(name = "ccwbInput") CCWBInput ccwbInput,
            Errors errors,
            Model model,
            Principal principal
    )
    {
        model.addAttribute("sections", sectionService.getProfileNumbers());

        if (errors.hasErrors()) {
            model.addAttribute("ccwbInput", ccwbInput);
            log.info("Errors appears while posting ccwb form");
            return "axial_force_calc";
        }

        try{
            CCWBCalculation calculation = ccwbCalculationService.createCalculation(ccwbInput,
                    userService.loadUserByUsername(principal.getName()));
            model.addAttribute("result", calculation.getResult());
            model.addAttribute("ccwbResultYBar", Math.round(calculation.getResult().getAxialComressionYRes() * 100));
            model.addAttribute("ccwbResultZBar", Math.round(calculation.getResult().getAxialComressionZRes() * 100));
            model.addAttribute("ccwbInput", calculation.getInput());
            log.info("Posting ccwb form with input id: {}", calculation.getInput().getId());
        }
        catch (SteelDoesntExistsException e) {
            errors.rejectValue("steel", null,"errors.axial-force-calc.steel.doesnt-exist");
            log.info("Calculation failed :" + e);
        }
            return "axial_force_calc";
    }

    @PostMapping("/save")
    public String saveAxialCompressionOrTension(@ModelAttribute(name = "ccwbInputId") Long ccwbInputId,
                                                Model model){
        model.addAttribute("sections", sectionService.getProfileNumbers());
        CCWBInput ccwbInput = ccwbCalculationService.findCCWBInput(ccwbInputId);
        ccwbCalculationService.saveCalculationToSaved(ccwbInput);
        model.addAttribute("ccwbInput", ccwbInput);
        log.info("Saving calculation with input id : {}", ccwbInput.getId());
        return "axial_force_calc";
    }

    private void initColCalc(Model model) {
        model.addAttribute("ccwbInput", new CCWBInput());
        model.addAttribute("sections", sectionService.getProfileNumbers());
        model.addAttribute("result", null);
        model.addAttribute("sectionNumber", null);
    }
}
