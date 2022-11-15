package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.dtos.validators.annotation.PasswordsMatch;
import ro.tuc.ds2020.dtos.validators.annotation.ValidEmail;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@PasswordsMatch(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class RegisterUserDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @ValidEmail(emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    private String password;
    private String confirmPassword;
    private String role;

    public RegisterUserDTO() {
    }

    public RegisterUserDTO(String firstName, String lastName, String email, String password, String confirmPassword, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterUserDTO userDTO = (RegisterUserDTO) o;
        return Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(confirmPassword, userDTO.confirmPassword) &&
                Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password, role);
    }
}
