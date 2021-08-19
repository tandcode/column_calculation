package ua.com.dbncalc.steel.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ua.com.dbncalc.steel.dto.UserRegistrationDTO;
import ua.com.dbncalc.steel.repositories.UserRepository;
import ua.com.dbncalc.steel.services.UserService;
import ua.com.dbncalc.steel.services.exceptions.UserWithEmailAlreadyExistException;
import ua.com.dbncalc.steel.services.exceptions.UserWithUsernameAlreadyExistException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;


    @Test
    void givenMatchingEmailPassword_whenPostNewUser_thenFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/registration")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.TEXT_HTML)
                .param("username", "testuser")
                .param("password", "testpass")
                .param("matchingPassword", "testpass")
                .param("email", "test@test.com")
                )
                .andExpect(model().hasNoErrors())
                .andExpect(status().isFound());
    }

    @Test
    void givenUnmatchingPassword_whenPostNewUser_thenError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/registration")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.TEXT_HTML)
                .param("username", "testuser")
                .param("password", "testpass")
                .param("matchingPassword", "1")
                .param("email", "test@test.com")
        )
                .andExpect(model().attributeHasErrors("user"))
                .andExpect(status().isOk());
    }

    @Test
    void givenInvalidEmail_whenPostNewUser_thenError() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/registration")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.TEXT_HTML)
                        .param("username", "testuser")
                        .param("password", "testpass")
                        .param("matchingPassword", "testpass")
                        .param("email", "test")
        )
                .andExpect(model().attributeHasFieldErrors("user", "email"))
                .andExpect(status().isOk());
    }

    @Test
    void givenExistingUsername_whenPostNewUser_thenError() throws Exception {
        when(userService.addUser(any(UserRegistrationDTO.class)))
                .thenThrow(UserWithUsernameAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/registration")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.TEXT_HTML)
                .param("username", "testuser")
                .param("password", "testpass")
                .param("matchingPassword", "testpass")
                .param("email", "test@test.com")
        )
                .andExpect(model().attributeHasFieldErrors("user", "username"))
                .andExpect(status().isOk());
    }

    @Test
    void givenExistingEmail_whenPostNewUser_thenError() throws Exception {
        when(userService.addUser(any(UserRegistrationDTO.class)))
                .thenThrow(UserWithEmailAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/registration")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept(MediaType.TEXT_HTML)
                .param("username", "testuser")
                .param("password", "testpass")
                .param("matchingPassword", "testpass")
                .param("email", "test@test.com")
        )
                .andExpect(model().attributeHasFieldErrors("user", "email"))
                .andExpect(status().isOk());
    }
}