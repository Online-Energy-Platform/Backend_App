package ro.tuc.ds2020.dtos;

import org.springframework.beans.BeanWrapperImpl;
import ro.tuc.ds2020.dtos.validators.annotation.PasswordsMatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class RegisterClientDTO implements ConstraintValidator<PasswordsMatch, Object> {

    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    private String password;
    private String confirmPassword;

    public RegisterClientDTO() {
    }

    public RegisterClientDTO(UUID id, String firstName, String lastName, String email, String password, String confirmPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterClientDTO clientDTO = (RegisterClientDTO) o;
        return Objects.equals(firstName, clientDTO.firstName) &&
                Objects.equals(lastName, clientDTO.lastName) &&
                Objects.equals(email, clientDTO.email) &&
                Objects.equals(password, clientDTO.password) &&
                Objects.equals(confirmPassword, clientDTO.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object password = new BeanWrapperImpl(o).getPropertyValue(getPassword());
        Object confirmPassword = new BeanWrapperImpl(o).getPropertyValue(getConfirmPassword());

        if(password != null){
            return password.equals(confirmPassword);
        }
        else{
            return confirmPassword == null;
        }
    }
}
