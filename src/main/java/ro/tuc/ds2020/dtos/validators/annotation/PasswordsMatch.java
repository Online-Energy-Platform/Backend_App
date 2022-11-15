package ro.tuc.ds2020.dtos.validators.annotation;

import ro.tuc.ds2020.dtos.validators.PasswordsMatchValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PasswordsMatchValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {

    String message() default "Passwords do not match!";
    String password();
    String confirmPassword();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

