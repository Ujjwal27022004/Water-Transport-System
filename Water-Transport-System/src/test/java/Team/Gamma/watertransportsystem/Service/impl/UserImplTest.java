package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Dto.LoginDTO;
import Team.Gamma.watertransportsystem.Dto.UserDTO;
import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Repository.UserRepository;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class UserImplTest {

    @Mock
    private UserRepository userRepo;

    @InjectMocks
    private UserImpl userService;

    private UserDTO userDTO;
    private LoginDTO loginDTO;
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Prepare test data
        userDTO = new UserDTO(1L, "username", "email@example.com", "password");
        loginDTO = new LoginDTO("email@example.com", "password");
        user = new User(1L, "username", "email@example.com", "password");
    }

    @Test
    void addUser_Success() {
        // Given
        given(userRepo.save(any(User.class))).willReturn(user);

        // When
        LoginMessage response = userService.addUser(userDTO);

        // Then
        //assertTrue(response.isSuccess());
        assertEquals("Signup Successfully", response.getMessage());
    }

    @Test
    void addUser_Error() {
        // Given
        given(userRepo.save(any(User.class))).willThrow(new RuntimeException("Error"));

        // When
        LoginMessage response = userService.addUser(userDTO);

        // Then
        //assertFalse(response.isSuccess());
        assertEquals("Error during signup: Error", response.getMessage());
    }

    @Test
    void loginUser_Success() {
        // Given
        given(userRepo.findByEmail(anyString())).willReturn(user);
        given(userRepo.findOneByEmailAndPassword(anyString(), anyString())).willReturn(Optional.of(user));

        // When
        LoginMessage response = userService.loginUser(loginDTO);

        // Then
        //assertTrue(response.isSuccess());
        assertEquals("Login Success", response.getMessage());
    }

    @Test
    void loginUser_EmailNotFound() {
        // Given
        given(userRepo.findByEmail(anyString())).willReturn(null);

        // When
        LoginMessage response = userService.loginUser(loginDTO);

        // Then
        //assertFalse(response.isSuccess());
        assertEquals("Email does not exist", response.getMessage());
    }

    @Test
    void loginUser_PasswordMismatch() {
        // Given
        given(userRepo.findByEmail(anyString())).willReturn(user);

        // When
        LoginMessage response = userService.loginUser(new LoginDTO("email@example.com", "wrongPassword"));

        // Then
        //assertFalse(response.isSuccess());
        assertEquals("Password does not match", response.getMessage());
    }

    @Test
    void updateProfile_Success() {
        // Given
        given(userRepo.findByUserid(anyLong())).willReturn(Optional.of(user));
        given(userRepo.save(any(User.class))).willReturn(user);

        UserDTO updateDTO = new UserDTO(1L, "newUsername", "newEmail@example.com", "newPassword");

        // When
        LoginMessage response = userService.updateProfile(1L, updateDTO);

        // Then
        //assertTrue(response.isSuccess());
        assertEquals("Profile Updated Successfully", response.getMessage());
    }

    @Test
    void updateProfile_UserNotFound() {
        // Given
        given(userRepo.findByUserid(anyLong())).willReturn(Optional.empty());

        UserDTO updateDTO = new UserDTO(1L, "newUsername", "newEmail@example.com", "newPassword");

        // When
        LoginMessage response = userService.updateProfile(1L, updateDTO);

        // Then
        //assertFalse(response.isSuccess());
        assertEquals("User not found with ID: 1", response.getMessage());
    }

    @Test
    void getUserDetails_Success() {
        // Given
        given(userRepo.findByUserid(anyLong())).willReturn(Optional.of(user));

        // When
        User result = userService.getUserDetails(1L);

        // Then
        assertNotNull(result);
        assertEquals(1L, result.getUserid());
        assertEquals("username", result.getUsername());
    }

    @Test
    void getUserDetails_UserNotFound() {
        // Given
        given(userRepo.findByUserid(anyLong())).willReturn(Optional.empty());

        // When
        User result = userService.getUserDetails(1L);

        // Then
        assertNull(result);
    }
}
