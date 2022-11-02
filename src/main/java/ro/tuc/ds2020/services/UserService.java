package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ClientDTO;
import ro.tuc.ds2020.dtos.RegisterClientDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<ClientDTO> findClients() {
        return null;
    }

    public UUID insert(RegisterClientDTO clientDTO) {
 //       User userToInsert = UserBuilder.toEntity(clientDTO);
//        userRepository.
        return null;
    }
}
