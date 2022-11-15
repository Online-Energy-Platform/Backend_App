package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.EditUserDTO;
import ro.tuc.ds2020.dtos.LoginUserDTO;
import ro.tuc.ds2020.dtos.RegisterUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.Role;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.RoleRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> findUsers() {
        List<User> userList = userRepository.findAll();
        LOGGER.info("S-au returnat " + userList.size() + " users!");
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User user: userList){
            UserDTO userDTO = UserBuilder.toUserDTO(user, user.getRole().getPosition());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    public UUID insert(RegisterUserDTO userDTO) {
        Optional<Role> role = roleRepository.findByPosition(userDTO.getRole());
        User userToInsert;
        if(role.isPresent()){
            userToInsert = UserBuilder.toEntity(userDTO, role.get());
        }
        else{
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with position: " + userDTO.getRole());
        }
        userRepository.save(userToInsert);
        return userToInsert.getId();
    }

    public EditUserDTO editUser(UUID id, EditUserDTO editUserDTO) {
        Optional<User> user = userRepository.findById(id);
        User editedUser;
        if(user.isPresent()){
            editedUser = UserBuilder.editUserDTOToEntity(editUserDTO, user.get());
            userRepository.save(editedUser);
        }
        else{
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id);
        }
        return UserBuilder.entityToEditedUserDTO(editedUser);
    }

    public UUID deleteUser(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id);
        }
        userRepository.deleteById(id);
        return id;
    }

    public UserDTO getUser(UUID id) {
        Optional<User> foundUser = userRepository.findById(id);
        if(!foundUser.isPresent()){
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with id: " + id);
        }
        User user = foundUser.get();
        return UserBuilder.toUserDTO(user, user.getRole().getPosition());
    }

    public UserDTO loginUser(String email, LoginUserDTO loginUserDTO) {
        Optional<User> foundUser = userRepository.findUserByEmailAndPassword(email, loginUserDTO.getPassword());
        if(!foundUser.isPresent()){
            throw new ResourceNotFoundException(User.class.getSimpleName() + " with the given email and password");
        }
        User user = foundUser.get();
        return UserBuilder.toUserDTO(user, user.getRole().getPosition());
    }
}
