package ro.tuc.ds2020.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import ro.tuc.ds2020.Ds2020TestConfig;
import ro.tuc.ds2020.dtos.RegisterUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.util.List;
import java.util.UUID;

@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/create.sql")
@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/delete.sql")
public class UserServiceIntegrationTests extends Ds2020TestConfig {

    @Autowired
    UserService userService;

    @Test
    public void testGetCorrect() {
        List<UserDTO> userDTOList = userService.findUsers();
        assertEquals("Test Insert User", 1, userDTOList.size());
    }

    @Test
    public void testInsertCorrectWithGetById() {
        RegisterUserDTO u = new RegisterUserDTO("John", "Travolta", "email@email.com", "parola", "parola", "CLIENT");
        UUID insertedID = userService.insert(u);

        UserDTO insertedUser = new UserDTO(insertedID, u.getFirstName() + " " + u.getLastName(), u.getEmail(), u.getRole());
        UserDTO fetchedUser = userService.getUser(insertedID);

        assertEquals("Test Inserted User", insertedUser, fetchedUser);
    }

    @Test
    public void testInsertCorrectWithGetAll() {
        RegisterUserDTO u = new RegisterUserDTO("John", "Travolta", "email@email.com", "parola", "parola", "CLIENT");
        userService.insert(u);

        List<UserDTO> userDTOList = userService.findUsers();
        assertEquals("Test Inserted Users", 2, userDTOList.size());
    }
}
