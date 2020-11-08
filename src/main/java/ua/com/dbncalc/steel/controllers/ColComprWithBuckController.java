package ua.com.dbncalc.steel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.dbncalc.steel.dao.ColComprWithBuckInputDao;
import ua.com.dbncalc.steel.models.ColComprWithBuckInput;
import ua.com.dbncalc.steel.services.ColComprWithBuckService;

@Controller
public class ColComprWithBuckController {

    private final ColComprWithBuckInputDao inputDao;

    @Autowired
    public ColComprWithBuckController(ColComprWithBuckInputDao inputDao) {
        this.inputDao = inputDao;
    }

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
        service.calculateEffectiveLengthY();
        model.addAttribute("colComprWithBuckService", service);
        return "result";
    }


}
