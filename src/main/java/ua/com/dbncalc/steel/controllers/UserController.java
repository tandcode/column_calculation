package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.dbncalc.steel.models.Role;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.UserRepository;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user-list";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute(user);
        return "user-edit";
    }
    @PostMapping
    public String userSave(
            @RequestParam("userId") User user,
            @RequestParam String username,
            @RequestParam(required = false) String manager,
            @RequestParam(required = false) String active
//            @Valid @ModelAttribute User user
    ) {
        user.setUsername(username);
//        user.getRoles().clear();
        if(manager != null) user.getRoles().add(Role.ADMIN);
        else {
            user.getRoles().remove(Role.ADMIN);
        }
        user.setActive("on".equals(active));
        log.info("Creating/Updating user: " + user);
        userRepository.save(user);
        return "redirect:/user";
    }
}
