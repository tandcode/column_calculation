package ua.com.dbncalc.steel.services;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.dbncalc.steel.dto.UserEditDTO;
import ua.com.dbncalc.steel.dto.UserRegistrationDTO;
import ua.com.dbncalc.steel.models.Role;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.UserRepository;
import ua.com.dbncalc.steel.services.exceptions.UserWithEmailAlreadyExistException;
import ua.com.dbncalc.steel.services.exceptions.UserWithUsernameAlreadyExistException;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    void givenValidUserDTO_whenAddUser_thenIsSaved() throws UserWithUsernameAlreadyExistException, UserWithEmailAlreadyExistException {
        UserRegistrationDTO userDTO = UserRegistrationDTO.builder()
                .username("test")
                .build();
        User user = userService.addUser(userDTO);
        Mockito.doReturn(Optional.of(User.builder().build())).when(userRepository).findByUsername("test");
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void givenUserDTOWithExistingUsername_whenAddUser_thenThrowsUserWithUsernameAlreadyExistException() {
        UserRegistrationDTO user = UserRegistrationDTO.builder()
                .username("test")
                .build();
        Mockito.doReturn(Optional.of(User.builder().build())).when(userRepository).findByUsername("test");
        assertThrows(UserWithUsernameAlreadyExistException.class, () -> {
            userService.addUser(user);
        });
        Mockito.verify(userRepository, Mockito.times(0)).save(any(User.class));
    }


    @Test
    void givenUserDTOWithExistingEmail_whenAddUser_thenThrowsUserWithEmailAlreadyExistException() {
        UserRegistrationDTO user = UserRegistrationDTO.builder()
                .email("test@test.com")
                .build();
        Mockito.doReturn(Optional.of(User.builder().build())).when(userRepository).findByEmail("test@test.com");
        assertThrows(UserWithEmailAlreadyExistException.class, () -> {
            userService.addUser(user);
        });
        Mockito.verify(userRepository, Mockito.times(0)).save(any(User.class));
    }

    @Test
    void mapUserToUserDTOTest(){
        User user = User.builder()
                .id(123l)
                .username("test")
                .password("testPass")
                .email("test@")
                .active(true)
                .roles(Set.of(Role.USER, Role.ADMIN))
                .build();

        UserEditDTO userEditDTO = userService.mapUserToUserDTO(user);

        assertEquals(user.getId(), userEditDTO.getId());
        assertEquals(user.getUsername(), userEditDTO.getUsername());
        assertEquals(user.getEmail(), userEditDTO.getEmail());
        assertEquals(user.isActive(), userEditDTO.isActive());
        assertEquals(user.getRoles().contains(Role.ADMIN), userEditDTO.isAdmin());
    }
}