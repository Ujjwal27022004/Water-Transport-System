package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Service.AdminService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import Team.Gamma.watertransportsystem.Dto.LoginDTO;
import Team.Gamma.watertransportsystem.Dto.UserDTO;
import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Service.UserService;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;
    @Mock
    private AdminService adminService;



    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void signup() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("testuser");
        userDTO.setEmail("testuser@example.com");
        userDTO.setPassword("password");

        LoginMessage expectedResponse = new LoginMessage("Signup Successfully", true);
        when(userService.addUser(userDTO)).thenReturn(expectedResponse);

        ResponseEntity<?> response = userController.signup(userDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }
    @Order(2)
    @Test
    void login() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmail("testuser@example.com");
        loginDTO.setPassword("password");

        LoginMessage expectedResponse = new LoginMessage("Login Success", true);
        when(userService.loginUser(loginDTO)).thenReturn(expectedResponse);

        ResponseEntity<?> response = userController.login(loginDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }
    @Order(3)
    @Test
    void updateProfile() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("updateduser");
        userDTO.setEmail("updateduser@example.com");
        userDTO.setPassword("newpassword");

        LoginMessage expectedResponse = new LoginMessage("Profile Updated Successfully", true);
        when(userService.updateProfile(userId, userDTO)).thenReturn(expectedResponse);

        ResponseEntity<?> response = userController.updateProfile(userId, userDTO);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }
    @Order(4)
    @Test
    void getUserDetails() {
        Long userId = 1L;
        User expectedUser = new User();
        expectedUser.setUserid(userId);
        expectedUser.setUsername("testuser");
        expectedUser.setEmail("testuser@example.com");

        when(userService.getUserDetails(userId)).thenReturn(expectedUser);

        User user = userController.getUserDetails(userId);

        assertEquals(expectedUser.getUserid(), user.getUserid());
        assertEquals(expectedUser.getUsername(), user.getUsername());
        assertEquals(expectedUser.getEmail(), user.getEmail());
    }
}
