package ro.tuc.ds2020.dtos;

import ro.tuc.ds2020.dtos.validators.annotation.ValidEmail;

import java.util.Objects;

public class EditUserDTO {

    private String firstName;
    private String lastName;
    @ValidEmail(emailPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    private String password;

    public EditUserDTO(){

    }

    public EditUserDTO(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditUserDTO userDTO = (EditUserDTO) o;
        return Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password);
    }

}
