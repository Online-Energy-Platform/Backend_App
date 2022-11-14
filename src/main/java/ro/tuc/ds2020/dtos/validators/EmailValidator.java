package ro.tuc.ds2020.dtos.validators;

import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.validators.annotation.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    String emailPattern;

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        emailPattern = constraintAnnotation.emailPattern();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(emailPattern);
        return (email == null) || (pattern.matcher(email).matches()); //se accepta email dupa regex sau camp null -> nu se modifica in db.
    }
}
