package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.dbncalc.steel.dto.UserRegistrationDTO;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.services.UserService;
import ua.com.dbncalc.steel.services.exceptions.UserWithEmailAlreadyExistException;
import ua.com.dbncalc.steel.services.exceptions.UserWithUsernameAlreadyExistException;

import javax.validation.Valid;

@Controller
@Slf4j
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", UserRegistrationDTO.builder().build());
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid @ModelAttribute("user") UserRegistrationDTO user,
                          Errors errors,
                          Model model) {
        if(errors.hasErrors()) {
            log.info("Failure to register user, error appears :" + user);
            model.addAttribute("user", user);
            return "registration";
        }
            User mappedUser;
            try {
                mappedUser = userService.addUser(user);
            } catch (UserWithUsernameAlreadyExistException |
                    UserWithEmailAlreadyExistException e) {
                if (e instanceof UserWithUsernameAlreadyExistException) {
                    errors.rejectValue("username", null, "errors.registration.userWithUsernameExists");
                    log.info("Failure to register user with existing username:" + user);
                } else {
                    errors.rejectValue("email", null, "errors.registration.userWithEmailExists");
                    log.info("Failure to register user with existing email:" + user);
                }
                model.addAttribute("user", user);
                return "registration";
            }
        log.info("Registering user :" + mappedUser);
        return "redirect:/login";
    }
}
