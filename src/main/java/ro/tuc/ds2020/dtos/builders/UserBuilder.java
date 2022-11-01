package ro.tuc.ds2020.dtos.builders;

//import ro.tuc.ds2020.entities.Person;

import ro.tuc.ds2020.dtos.ClientDTO;
import ro.tuc.ds2020.dtos.RegisterClientDTO;
import ro.tuc.ds2020.entities.Role;
import ro.tuc.ds2020.entities.User;

public class UserBuilder {

    private UserBuilder() {
    }

    public static ClientDTO toClientDTO(User user){
        return new ClientDTO(user.getId(), user.getFirstName() + " " + user.getLastName(), user.getEmail());
    }

    public static User toEntity(RegisterClientDTO clientDTO) {
        return new User(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(), clientDTO.getPassword(), new Role("ADMIN"));
    }
}
