package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.dbncalc.steel.services.CCWBCalculationService;
import ua.com.dbncalc.steel.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/my-calculations")
@Slf4j
public class MyCalculationsController {

    @Autowired
    private UserService userService;

    @Autowired
    private CCWBCalculationService ccwbCalculationService;

    @GetMapping("/recent")
    public String mySavedCalculations(Model model,
                                 Principal principal) {
        model.addAttribute("calculations", ccwbCalculationService
                .getUserCalculations(userService
                        .loadUserByUsername(principal.getName())));
        return "my_calculations";
    }

    @GetMapping("/saved")
    public String myRecentCalculations(Model model,
                                 Principal principal) {
        model.addAttribute("calculations", ccwbCalculationService
                .getSavedUserCalculations(userService
                        .loadUserByUsername(principal.getName())));
        return "my_calculations";
    }
}
