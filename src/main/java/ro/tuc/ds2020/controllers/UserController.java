package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ClientDTO;
import ro.tuc.ds2020.dtos.RegisterClientDTO;
import ro.tuc.ds2020.services.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController //annotare pentru a nota ca acesta este un controller ce implementeaza REST services.
@CrossOrigin //pentru a avea acces la controller din exterior.
@RequestMapping(value = "/user")  //precizam faptul ca resursele din controller sunt mapate la adresa: "http://localhost:8080/user".
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET ALL USERS THAT ARE CLIENTS(id, full name, email):
    /*
    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientDTO>> getClients(){
        List<ClientDTO> clientDtos = userService.findClients();
        return new ResponseEntity<>(clientDtos, HttpStatus.OK);
    }

    //CREATE A NEW CLIENT(id, firstName, lastName, email, password si role-ul va fi automat de client din repository-ul user-ului):
    @PostMapping()
    public ResponseEntity<UUID> insertClient(@Valid @RequestBody RegisterClientDTO clientDTO) {
        UUID personID = userService.insert(clientDTO);
        return new ResponseEntity<>(personID, HttpStatus.CREATED);
    }
    */


//    public ResponseEntity<List<PersonDTO>> getPersons() {
//        List<PersonDTO> dtos = personService.findPersons();
//        for (PersonDTO dto : dtos) {
//            Link personLink = linkTo(methodOn(PersonController.class)
//                    .getPerson(dto.getId())).withRel("personDetails");
//            dto.add(personLink);
//        }
//        return new ResponseEntity<>(dtos, HttpStatus.OK);
//    }
//
//    @PostMapping()
//    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody PersonDetailsDTO personDTO) {
//        UUID personID = personService.insert(personDTO);
//        return new ResponseEntity<>(personID, HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<PersonDetailsDTO> getPerson(@PathVariable("id") UUID personId) {
//        PersonDetailsDTO dto = personService.findPersonById(personId);
//        return new ResponseEntity<>(dto, HttpStatus.OK);
//    }
//
//    //TODO: UPDATE, DELETE per resource

}
