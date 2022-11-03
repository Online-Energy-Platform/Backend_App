package ro.tuc.ds2020.dtos.validators.annotation;

import ro.tuc.ds2020.dtos.RegisterClientDTO;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Constraint(validatedBy = RegisterClientDTO.class)
//@Target({ ElementType.TYPE })
//@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {


//    String message() default "Passwords don't match!";
//
//    String password();
//    String confirmPassword();

}

