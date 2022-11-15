package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.EditUserDTO;
import ro.tuc.ds2020.dtos.RegisterUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.Role;
import ro.tuc.ds2020.entities.User;

import java.util.Optional;

public class UserBuilder {

    private UserBuilder() {
    }

    public static UserDTO toUserDTO(User user, String role){
        return new UserDTO(user.getId(), user.getFirstName() + " " + user.getLastName(), user.getEmail(), role);
    }

    public static User toEntity(RegisterUserDTO userDTO, Role role) {
        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword(), role);
    }

    public static User editUserDTOToEntity(EditUserDTO editUserDTO, User user){
        String firstName = editUserDTO.getFirstName();
        String lastName = editUserDTO.getLastName();
        String email = editUserDTO.getEmail();
        String password = editUserDTO.getPassword();
        //System.err.println(firstName + ' ' + lastName + ' ' + email + ' ' + password);
        if(firstName != null){
            user.setFirstName(firstName);
        }
        if(lastName != null){
            user.setLastName(lastName);
        }
        if(email != null){
            user.setEmail(email);
        }
        if(password != null){
            user.setPassword(password);
        }
        return user;
     }

     public static EditUserDTO entityToEditedUserDTO(User user){
        return new EditUserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
     }
}
