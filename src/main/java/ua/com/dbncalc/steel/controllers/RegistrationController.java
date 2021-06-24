package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.services.UserService;

import java.util.Map;

@Controller
@Slf4j
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {

        if(!userService.addUser(user)) {
            model.put("message", "User exists!");
            log.info("Trying to register existing user :" + user);
            return "registration";
        }
        log.info("Registering user :" + user);
        return "redirect:/login";
    }
}
