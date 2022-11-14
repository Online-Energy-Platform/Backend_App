package ro.tuc.ds2020.dtos.validators;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.validators.annotation.PasswordsMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, Object> {

    private String password;
    private String confirmPassword;

    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {
        password = constraintAnnotation.password();
        confirmPassword = constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordObject = new BeanWrapperImpl(o).getPropertyValue(password);
        Object confirmPasswordObject = new BeanWrapperImpl(o).getPropertyValue(confirmPassword);
        if(passwordObject != null){
            return passwordObject.equals(confirmPasswordObject);
        }
        else{
            return false;
        }
    }

}
