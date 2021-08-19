package ua.com.dbncalc.steel.services;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.dbncalc.steel.dto.UserEditDTO;
import ua.com.dbncalc.steel.dto.UserRegistrationDTO;
import ua.com.dbncalc.steel.models.Role;
import ua.com.dbncalc.steel.models.User;
import ua.com.dbncalc.steel.repositories.UserRepository;
import ua.com.dbncalc.steel.services.exceptions.UserWithEmailAlreadyExistException;
import ua.com.dbncalc.steel.services.exceptions.UserWithUsernameAlreadyExistException;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User loadUserByUsername(String username)  {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username: " + username));
    }

    public User addUser(UserRegistrationDTO userDTO) throws UserWithUsernameAlreadyExistException, UserWithEmailAlreadyExistException {
        if(usernameExist(userDTO.getUsername())) throw new UserWithUsernameAlreadyExistException();
        if(emailExist(userDTO.getEmail())) throw new UserWithEmailAlreadyExistException();

        User user = mapUserRegistrationDTOToUser(userDTO, User.builder().build());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return user;
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public UserEditDTO mapUserToUserDTO(User user){
        Converter<Set<Role>, Boolean> isUserAdmin = ctx -> ctx.getSource().contains(Role.ADMIN);
        modelMapper.typeMap(User.class, UserEditDTO.class).addMappings(mapper -> {
            mapper.using(isUserAdmin)
                    .map(User::getRoles,
                            UserEditDTO::setAdmin);
        });
        return modelMapper.map(user, UserEditDTO.class);
    }

    public User mapUserDTOToUser(UserEditDTO userEditDTO, User user){
        Converter<Boolean, Set<Role>> isUserDTOAdmin = ctx -> {
                Set<Role> roles = Stream.of(Role.USER).collect(Collectors.toSet());
                if(ctx.getSource()) roles.add(Role.ADMIN);
                return roles;
        };

        modelMapper.typeMap(UserEditDTO.class, User.class).addMappings(mapper -> {
            mapper.using(isUserDTOAdmin)
                    .map(UserEditDTO::isAdmin,
                            User::setRoles);
        });
        modelMapper.map(userEditDTO, user);
        return user;
    }

    public User mapUserRegistrationDTOToUser(UserRegistrationDTO userRegistrationDTO, User user){
        modelMapper.typeMap(UserRegistrationDTO.class, User.class).addMappings(mapper -> {
            mapper.map(src -> true, User::setActive);
            mapper.map(src -> Collections.singleton(Role.USER), User::setRoles);
            mapper.map(UserRegistrationDTO::getPassword, User::setPassword);
        });
        modelMapper.map(userRegistrationDTO, user);
        return user;
    }
}
