package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private Long userId = 1L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test data
        user = new User();
        user.setUserid(userId);
        user.setUsername("John Doe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password123");
    }

    @Test
    void searchUser_Success() {
        // Given
        given(userRepository.searchUser(userId)).willReturn(user);

        // When
        User result = userService.searchUser(userId);

        // Then
        assertNotNull(result);
        assertEquals(userId, result.getUserid());
    }

    @Test
    void searchUser_NotFound() {
        // Given
        given(userRepository.searchUser(userId)).willReturn(null);

        // When
        User result = userService.searchUser(userId);

        // Then
        assertNull(result);
    }

    @Test
    void removeUser_Success() {
        // Given
        willDoNothing().given(userRepository).deleteById(userId);

        // When
        String response = userService.removeUser(userId);

        // Then
        assertEquals("User Removed Successfully!", response);
    }

    @Test
    void updateUser_Success() {
        // Given
        given(userRepository.save(user)).willReturn(user);

        // When
        String response = userService.updateUser(user);

        // Then
        assertEquals("User updated Successfully!", response);
    }

    @Test
    void getAllUsers_Success() {
        // Given
        User user1 = new User();
        user1.setUserid(2L);
        user1.setUsername("Jane Doe");
        user1.setEmail("janedoe@example.com");

        given(userRepository.findAll()).willReturn(Arrays.asList(user, user1));

        // When
        var result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
