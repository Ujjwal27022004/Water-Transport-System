package Team.Gamma.Water_Transport_System.Dto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LoginDTOTest {

    @Test
    void testDefaultConstructorAndSetters() {
        // Create an instance using the default constructor
        LoginDTO loginDTO = new LoginDTO();

        // Test setting and getting email
        String expectedEmail = "user@example.com";
        loginDTO.setEmail(expectedEmail);
        assertEquals(expectedEmail, loginDTO.getEmail(), "Email should match the value set");

        // Test setting and getting password
        String expectedPassword = "mypassword123";
        loginDTO.setPassword(expectedPassword);
        assertEquals(expectedPassword, loginDTO.getPassword(), "Password should match the value set");
    }

    @Test
    void testParameterizedConstructor() {
        // Create an instance using the parameterized constructor
        String expectedEmail = "admin@example.com";
        String expectedPassword = "securepassword123";
        LoginDTO loginDTO = new LoginDTO(expectedEmail, expectedPassword);

        // Test values set by the constructor
        assertEquals(expectedEmail, loginDTO.getEmail(), "Email should match the value set in the constructor");
        assertEquals(expectedPassword, loginDTO.getPassword(), "Password should match the value set in the constructor");
    }

    @Test
    void testEmptyValues() {
        // Create an instance with empty values
        LoginDTO loginDTO = new LoginDTO("", "");

        // Assert that empty values are set correctly
        assertEquals("", loginDTO.getEmail(), "Email should be empty");
        assertEquals("", loginDTO.getPassword(), "Password should be empty");
    }

    @Test
    void testNullValues() {
        // Create an instance with null values
        LoginDTO loginDTO = new LoginDTO(null, null);

        // Assert that null values are set correctly
        assertNull(loginDTO.getEmail(), "Email should be null");
        assertNull(loginDTO.getPassword(), "Password should be null");
    }

    @Test
    void testUpdateValues() {
        // Create an instance and set initial values
        LoginDTO loginDTO = new LoginDTO("initial@example.com", "initialpassword");

        // Update values
        String updatedEmail = "updated@example.com";
        String updatedPassword = "updatedpassword";
        loginDTO.setEmail(updatedEmail);
        loginDTO.setPassword(updatedPassword);

        // Assert updated values
        assertEquals(updatedEmail, loginDTO.getEmail(), "Email should match the updated value");
        assertEquals(updatedPassword, loginDTO.getPassword(), "Password should match the updated value");
    }

    @Test
    void testConsistencyBetweenSettersAndConstructor() {
        // Create an instance using the constructor
        String email = "test@example.com";
        String password = "testpassword";
        LoginDTO loginDTO = new LoginDTO(email, password);

        // Update values using setters
        String newEmail = "new@example.com";
        String newPassword = "newpassword";
        loginDTO.setEmail(newEmail);
        loginDTO.setPassword(newPassword);

        // Assert updated values
        assertEquals(newEmail, loginDTO.getEmail(), "Email should match the new value set via setter");
        assertEquals(newPassword, loginDTO.getPassword(), "Password should match the new value set via setter");
    }
}
