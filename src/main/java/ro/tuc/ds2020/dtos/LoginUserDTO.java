package ro.tuc.ds2020.dtos;

import java.util.Objects;

public class LoginUserDTO { //facut pentru a transmite parola de la front la back -> aparent stringify nu merge asa usor
    //direct pe string, asa ca, ca sa nu mai pun dependente in backend, am facut un dto rapid ce contine doar parola.

    private String password;

    public LoginUserDTO(){

    }

    public LoginUserDTO(String password){
        this.password = password;
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
        LoginUserDTO userDTO = (LoginUserDTO) o;
        return Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }
}
