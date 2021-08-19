package ua.com.dbncalc.steel.models.validation;

import ua.com.dbncalc.steel.dto.UserRegistrationDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final UserRegistrationDTO user = (UserRegistrationDTO) obj;
        return user.getPassword() != null ? user.getPassword().equals(user.getMatchingPassword()) :
                user.getMatchingPassword() != null;
    }

}