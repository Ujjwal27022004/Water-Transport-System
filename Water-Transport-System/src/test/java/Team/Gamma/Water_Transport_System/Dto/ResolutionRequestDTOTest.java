package Team.Gamma.Water_Transport_System.Dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResolutionRequestDTOTest {

    @Test
    void testGettersAndSetters() {
        // Create an instance of ResolutionRequestDTO
        ResolutionRequestDTO resolutionRequestDTO = new ResolutionRequestDTO();

        // Test Resolution Details
        String expectedResolutionDetails = "Request resolved successfully";
        resolutionRequestDTO.setResolutionDetails(expectedResolutionDetails);
        assertEquals(expectedResolutionDetails, resolutionRequestDTO.getResolutionDetails(),
                "Resolution details should match the value set");

        // Test Status
        String expectedStatus = "RESOLVED";
        resolutionRequestDTO.setStatus(expectedStatus);
        assertEquals(expectedStatus, resolutionRequestDTO.getStatus(),
                "Status should match the value set");
    }

    @Test
    void testDefaultValues() {
        // Create an instance of ResolutionRequestDTO
        ResolutionRequestDTO resolutionRequestDTO = new ResolutionRequestDTO();

        // Test default values (should be null initially)
        assertNull(resolutionRequestDTO.getResolutionDetails(),
                "Default resolution details should be null");
        assertNull(resolutionRequestDTO.getStatus(),
                "Default status should be null");
    }

    @Test
    void testUpdateValues() {
        // Create an instance of ResolutionRequestDTO
        ResolutionRequestDTO resolutionRequestDTO = new ResolutionRequestDTO();

        // Set initial values
        resolutionRequestDTO.setResolutionDetails("Initial details");
        resolutionRequestDTO.setStatus("PENDING");

        // Update values
        String updatedDetails = "Updated resolution details";
        String updatedStatus = "RESOLVED";
        resolutionRequestDTO.setResolutionDetails(updatedDetails);
        resolutionRequestDTO.setStatus(updatedStatus);

        // Assert updated values
        assertEquals(updatedDetails, resolutionRequestDTO.getResolutionDetails(),
                "Resolution details should be updated correctly");
        assertEquals(updatedStatus, resolutionRequestDTO.getStatus(),
                "Status should be updated correctly");
    }

    @Test
    void testNullValues() {
        // Create an instance of ResolutionRequestDTO
        ResolutionRequestDTO resolutionRequestDTO = new ResolutionRequestDTO();

        // Set null values
        resolutionRequestDTO.setResolutionDetails(null);
        resolutionRequestDTO.setStatus(null);

        // Assert null values
        assertNull(resolutionRequestDTO.getResolutionDetails(),
                "Resolution details should be null when set to null");
        assertNull(resolutionRequestDTO.getStatus(),
                "Status should be null when set to null");
    }

    @Test
    void testEmptyStringValues() {
        // Create an instance of ResolutionRequestDTO
        ResolutionRequestDTO resolutionRequestDTO = new ResolutionRequestDTO();

        // Set empty string values
        resolutionRequestDTO.setResolutionDetails("");
        resolutionRequestDTO.setStatus("");

        // Assert empty string values
        assertEquals("", resolutionRequestDTO.getResolutionDetails(),
                "Resolution details should allow empty string");
        assertEquals("", resolutionRequestDTO.getStatus(),
                "Status should allow empty string");
    }
}
