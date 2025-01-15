package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Service.UserManagementService;
import Team.Gamma.Water_Transport_System.Exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserManagementControllerTest {

    @Mock
    private UserManagementService userManagementService;

    @InjectMocks
    private UserManagementController userManagementController;

    @Test
    void getUserDetailsById_UserFound() {
        User user = new User(1L, "John", "Doe", "john.doe@example.com");
        when(userManagementService.searchUser(1L)).thenReturn(user);

        User result = userManagementController.getUserDetailsById(1L);

        assertNotNull(result);
        verify(userManagementService, times(1)).searchUser(1L);
    }

    @Test
    void getUserDetailsById_UserNotFound() {
        when(userManagementService.searchUser(1L)).thenReturn(null);

        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            userManagementController.getUserDetailsById(1L);
        });

        assertEquals("User not found with ID: 1", exception.getMessage());
        verify(userManagementService, times(1)).searchUser(1L);
    }

    @Test
    void getAllUsers() {
        User user1 = new User(1L, "John", "Doe", "john.doe@example.com");
        User user2 = new User(2L, "Jane", "Doe", "jane.doe@example.com");
        List<User> users = Arrays.asList(user1, user2);
        when(userManagementService.getAllUsers()).thenReturn(users);

        List<User> result = userManagementController.getAllUsers();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(userManagementService, times(1)).getAllUsers();
    }

    @Test
    void editUser() {
        User user = new User(1L, "John", "Doe", "john.doe@example.com");

        // Assume that the update is successful
        //doNothing().when(userManagementService).updateUser(user);

        String result = userManagementController.editUser(user);

        assertEquals("User updated Successfully!", result);
        verify(userManagementService, times(1)).updateUser(user);
    }

//    @Test
//    void deleteUser() {
//        Long userId = 1L;
//
//        // Assume that the deletion is successful
//        //doNothing().when(userManagementService).removeUser(userId);
//
//        String result = userManagementController.deleteUser(userId);
//
//        assertEquals("User Deleted Successfully", result);
//        verify(userManagementService, times(1)).removeUser(userId);
//    }
}
