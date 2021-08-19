package ua.com.dbncalc.steel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.dbncalc.steel.models.validation.PasswordMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches(message = "errors.registration.passwordsDontMatch")
public class UserRegistrationDTO {
    @NotBlank(message="Username is required")
    private String username;
    @Email(message="Email is required")
    private String email;
    @NotBlank(message="Password is required")
    private String password;
    private String matchingPassword;
}
