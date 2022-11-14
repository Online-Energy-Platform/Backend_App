package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.EditUserDTO;
import ro.tuc.ds2020.dtos.LoginUserDTO;
import ro.tuc.ds2020.dtos.RegisterUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController //annotare pentru a nota ca acesta este un controller ce implementeaza REST services.
@CrossOrigin //pentru a avea acces la controller din exterior.
@RequestMapping(value = "/user")  //precizam faptul ca resursele din controller sunt mapate la adresa: "http://localhost:8080/user".
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET ALL USERS (id, full name, email, role: admin/client):
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> userDTOList = userService.findUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    //GET A USER (NOT USED):
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") UUID id){
        UserDTO userDTO = userService.getUser(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //SEARCH A USER BY EMAIL AND PASSWORD (FOR LOGIN):
    @PostMapping("/{email}")
    public ResponseEntity<UserDTO> loginUser(@PathVariable("email") String email, @RequestBody LoginUserDTO loginUserDTO){
        UserDTO userDTO = userService.loginUser(email, loginUserDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //CREATE A NEW CLIENT(id, firstName, lastName, email, password si role-ul va fi automat de client din repository-ul user-ului):
    @PostMapping()
    public ResponseEntity<UUID> insertUser(@Valid @RequestBody RegisterUserDTO userDTO) {
        UUID userID = userService.insert(userDTO);
        return new ResponseEntity<>(userID, HttpStatus.CREATED);
    }

    //LAS PATCH SAU PUN PUT? NU PREA ESTE O DIFERENTA DUPA MINE PT CA VERIFIC VALORILE DE NULL IN BUILDER.
    @PatchMapping("/{id}")
    public ResponseEntity<EditUserDTO> updateUser(@PathVariable("id") UUID id, @Valid @RequestBody EditUserDTO editUserDTO){
        EditUserDTO editedUser = userService.editUser(id, editUserDTO);
        return new ResponseEntity<>(editedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UUID> deleteUser(@PathVariable("id") UUID id){
        UUID deleteUserID = userService.deleteUser(id);
        return new ResponseEntity<>(deleteUserID, HttpStatus.OK);
    }

}
