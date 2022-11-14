package ro.tuc.ds2020.dtos.validators.annotation;

import ro.tuc.ds2020.dtos.validators.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EmailValidator.class})
public @interface ValidEmail {

    String emailPattern(); //unde pun pattern-ul pentru regex verification.

    String message() default "Email is not valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
