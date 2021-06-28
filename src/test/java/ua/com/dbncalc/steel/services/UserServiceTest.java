package ua.com.dbncalc.steel.services;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.dbncalc.steel.models.Role;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.UserRepository;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    public void addUser() {
        User user = User.builder().build();
        boolean addResult = userService.addUser(user);
        assertTrue(addResult);
        assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void addUserAlreadyExists() {
        User user = User.builder()
                .username("test")
                .build();
        Mockito.doReturn(Optional.of(User.builder().build())).when(userRepository).findByUsername("test");
        boolean addResult = userService.addUser(user);
        assertFalse(addResult);

        Mockito.verify(userRepository, Mockito.times(0)).save(ArgumentMatchers.any(User.class));
    }

}