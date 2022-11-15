package ro.tuc.ds2020.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.RegisterUserDTO;
import ro.tuc.ds2020.services.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerUnitTest extends Ds2020TestConfig {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void insertUserTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterUserDTO userDTO = new RegisterUserDTO("John", "Somewhere Else street", "email@email.com", "parola", "parola", "CLIENT");

        mockMvc.perform(post("/user")
                .content(objectMapper.writeValueAsString(userDTO))
                .contentType("application/json"))
                .andExpect(status().isCreated());
    }

    @Test
    public void insertUserTestFailsDueToAge() throws Exception {
        //aici testeaza daca da fail din vina varstei sub 18 ani
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterUserDTO personDTO = new RegisterUserDTO("John", "Somewhere Else street", "email","parola", "parola", "CLIENT");

        mockMvc.perform(post("/user")
                .content(objectMapper.writeValueAsString(personDTO))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void insertUserTestFailsDueToNull() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        RegisterUserDTO userDTO = new RegisterUserDTO("John", null, "email@email.com", "parola", "parola", "CLIENT");

        mockMvc.perform(post("/user")
                .content(objectMapper.writeValueAsString(userDTO))
                .contentType("application/json"))
                .andExpect(status().isBadRequest());
    }
}
