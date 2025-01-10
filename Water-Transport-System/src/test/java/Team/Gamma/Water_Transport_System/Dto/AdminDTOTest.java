package Team.Gamma.Water_Transport_System.Dto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AdminDTOTest {

    @Test
    void testAdminDTOGettersAndSetters() {
        // Create an instance of AdminDTO
        AdminDTO adminDTO = new AdminDTO();

        // Test setting and getting adminId
        Long expectedAdminId = 123L;
        adminDTO.setAdminId(expectedAdminId);
        assertEquals(expectedAdminId, adminDTO.getAdminId(), "Admin ID should match the value set");

        // Test setting and getting password
        String expectedPassword = "securepassword123";
        adminDTO.setPassword(expectedPassword);
        assertEquals(expectedPassword, adminDTO.getPassword(), "Password should match the value set");

        // Test setting and getting email
        String expectedEmail = "admin@example.com";
        adminDTO.setEmailId(expectedEmail);
        assertEquals(expectedEmail, adminDTO.getEmailId(), "Email should match the value set");
    }

    @Test
    void testNullValues() {
        AdminDTO adminDTO = new AdminDTO();

        // Test setting and getting null values
        adminDTO.setAdminId(null);
        assertNull(adminDTO.getAdminId(), "Admin ID should be null");

        adminDTO.setPassword(null);
        assertNull(adminDTO.getPassword(), "Password should be null");

        adminDTO.setEmailId(null);
        assertNull(adminDTO.getEmailId(), "Email should be null");
    }

    @Test
    void testEmptyStrings() {
        AdminDTO adminDTO = new AdminDTO();

        // Test setting and getting empty string values
        adminDTO.setPassword("");
        assertEquals("", adminDTO.getPassword(), "Password should be empty");

        adminDTO.setEmailId("");
        assertEquals("", adminDTO.getEmailId(), "Email should be empty");
    }

    @Test
    void testLargeValues() {
        AdminDTO adminDTO = new AdminDTO();

        // Test setting and getting large string values
        String longPassword = "a".repeat(1000);  // Large string
        adminDTO.setPassword(longPassword);
        assertEquals(longPassword, adminDTO.getPassword(), "Password should match the long value set");

        String longEmail = "longemail@" + "a".repeat(900) + ".com";  // Large email string
        adminDTO.setEmailId(longEmail);
        assertEquals(longEmail, adminDTO.getEmailId(), "Email should match the long value set");
    }

    @Test
    void testSpecialCharacters() {
        AdminDTO adminDTO = new AdminDTO();

        // Test setting and getting special characters in password and email
        String specialPassword = "@#$$%&*()_+123";
        adminDTO.setPassword(specialPassword);
        assertEquals(specialPassword, adminDTO.getPassword(), "Password should match the special characters");

        String specialEmail = "user@domain.com#test";
        adminDTO.setEmailId(specialEmail);
        assertEquals(specialEmail, adminDTO.getEmailId(), "Email should match the special characters");
    }
}
