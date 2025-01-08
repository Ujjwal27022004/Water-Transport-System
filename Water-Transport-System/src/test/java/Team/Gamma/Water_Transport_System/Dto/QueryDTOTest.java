package Team.Gamma.Water_Transport_System.Dto;
import Team.Gamma.Water_Transport_System.Entity.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class QueryDTOTest {

    @Test
    void testQueryDTOGettersAndSetters() {
        // Create a User object for association
        User user = new User();
        user.setUserid(1L);
        user.setUsername("Test User");

        // Test QueryDTO
        QueryDTO queryDTO = new QueryDTO();
        queryDTO.setQueryid(201L);
        queryDTO.setQueryDetails("Sample DTO Details");
        queryDTO.setQueryResolution("Resolved successfully");
        queryDTO.setStatus("Open");
        queryDTO.setCreatedDate(new Date());
        queryDTO.setResolvedDate(new Date());
        queryDTO.setUser(user);

        assertEquals(201L, queryDTO.getQueryid());
        assertEquals("Sample DTO Details", queryDTO.getQueryDetails());
        assertEquals("Resolved successfully", queryDTO.getQueryResolution());
        assertEquals("Open", queryDTO.getStatus());
        assertNotNull(queryDTO.getCreatedDate());
        assertNotNull(queryDTO.getResolvedDate());
        assertEquals(user, queryDTO.getUser());
    }

    @Test
    void testQueryDTOConstructor() {
        QueryDTO queryDTO = new QueryDTO("Sample DTO Details");

        assertEquals("Sample DTO Details", queryDTO.getQueryDetails());
        assertNull(queryDTO.getQueryid());
        assertNull(queryDTO.getQueryResolution());
        assertNull(queryDTO.getStatus());
        assertNull(queryDTO.getCreatedDate());
        assertNull(queryDTO.getResolvedDate());
        assertNull(queryDTO.getUser());
    }
}
