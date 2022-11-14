package ro.tuc.ds2020.dtos;

import java.util.Objects;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String fullName;
    private String email;
    private String role;

    public UserDTO() {
    }

    public UserDTO(UUID id, String fullName, String email, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        UserDTO clientDTO = (UserDTO) o;
        return Objects.equals(fullName, clientDTO.fullName) &&
                Objects.equals(email, clientDTO.email) &&
                Objects.equals(role, clientDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email, role);
    }
}
