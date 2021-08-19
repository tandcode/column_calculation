package ua.com.dbncalc.steel.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.dbncalc.steel.dto.UserEditDTO;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.UserRepository;
import ua.com.dbncalc.steel.services.UserService;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    private String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user_list";
    }

    @GetMapping("/{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        UserEditDTO userEditDTO = userService.mapUserToUserDTO(user);
        model.addAttribute(userEditDTO);
        return "user_edit";
    }
    @PostMapping
    public String userUpdate(
            @ModelAttribute UserEditDTO userEditDTO
    ) {
        User user = userRepository.findById(userEditDTO.getId()).orElseThrow();
        userService.mapUserDTOToUser(userEditDTO, user);
        log.info("Updating user: " + user);
        userRepository.save(user);
        return "redirect:/user";
    }
}
