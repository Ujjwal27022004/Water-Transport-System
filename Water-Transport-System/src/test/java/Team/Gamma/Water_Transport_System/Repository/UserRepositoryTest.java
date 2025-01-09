package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)  // Use MockitoExtension for unit tests
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        // Initialize the user object for testing
        user = new User();
        user.setUserid(1L);
        user.setEmail("user@example.com");
        user.setPassword("password123");
    }

    @Test
    void testFindOneByEmailAndPassword_Success() {
        // Mock the repository method
        when(userRepository.findOneByEmailAndPassword("user@example.com", "password123"))
                .thenReturn(Optional.of(user));

        // Perform the test
        Optional<User> foundUser = userRepository.findOneByEmailAndPassword("user@example.com", "password123");

        assertTrue(foundUser.isPresent(), "User should be found");
        assertEquals("user@example.com", foundUser.get().getEmail(), "Email should match");
        assertEquals("password123", foundUser.get().getPassword(), "Password should match");
    }

    @Test
    void testFindOneByEmailAndPassword_Failure() {
        // Mock the repository method to return empty Optional
        when(userRepository.findOneByEmailAndPassword("wrong@example.com", "wrongpassword"))
                .thenReturn(Optional.empty());

        // Perform the test
        Optional<User> foundUser = userRepository.findOneByEmailAndPassword("wrong@example.com", "wrongpassword");

        assertFalse(foundUser.isPresent(), "User should not be found with incorrect credentials");
    }

    @Test
    void testFindByEmail_Success() {
        // Mock the repository method
        when(userRepository.findByEmail("user@example.com")).thenReturn(user);

        // Perform the test
        User foundUser = userRepository.findByEmail("user@example.com");

        assertNotNull(foundUser, "User should be found by email");
        assertEquals("user@example.com", foundUser.getEmail(), "Email should match");
    }

    @Test
    void testFindByEmail_Failure() {
        // Mock the repository method to return null
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(null);

        // Perform the test
        User foundUser = userRepository.findByEmail("nonexistent@example.com");

        assertNull(foundUser, "User should not be found with non-existing email");
    }

    @Test
    void testFindByUserid_Success() {
        // Mock the repository method
        when(userRepository.findByUserid(1L)).thenReturn(Optional.of(user));

        // Perform the test
        Optional<User> foundUser = userRepository.findByUserid(1L);

        assertTrue(foundUser.isPresent(), "User should be found by userId");
        assertEquals(1L, foundUser.get().getUserid(), "User ID should match");
    }

    @Test
    void testFindByUserid_Failure() {
        // Mock the repository method to return empty Optional
        when(userRepository.findByUserid(2L)).thenReturn(Optional.empty());

        // Perform the test
        Optional<User> foundUser = userRepository.findByUserid(2L);

        assertFalse(foundUser.isPresent(), "User should not be found for non-existing userId");
    }

    @Test
    void testSearchUser_Success() {
        // Mock the repository method for searchUser query
        when(userRepository.searchUser(1L)).thenReturn(user);

        // Perform the test
        User foundUser = userRepository.searchUser(1L);

        assertNotNull(foundUser, "User should be found by userId via custom query");
        assertEquals(1L, foundUser.getUserid(), "User ID should match");
    }

    @Test
    void testSearchUser_Failure() {
        // Mock the repository method to return null for non-existing userId
        when(userRepository.searchUser(2L)).thenReturn(null);

        // Perform the test
        User foundUser = userRepository.searchUser(2L);

        assertNull(foundUser, "User should not be found for non-existing userId");
    }
}
