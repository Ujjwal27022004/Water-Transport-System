package Team.Gamma.water_transport_system.Entity;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class QueryTest {

    @Test
    void testQueryEntityGettersAndSetters() {
        // Create a User object for association
        User user = new User();
        user.setUserid(1L);
        user.setUsername("Test User");

        // Test Query Entity
        Query query = new Query();
        query.setqueryid(101L);
        query.setQueryDetails("Sample Query Details");
        query.setQueryResolution("Resolved successfully");
        query.setStatus("Resolved");
        query.setCreatedDate(new Date());
        query.setResolvedDate(new Date());
        query.setUser(user);

        assertEquals(101L, query.getqueryid());
        assertEquals("Sample Query Details", query.getQueryDetails());
        assertEquals("Resolved successfully", query.getQueryResolution());
        assertEquals("Resolved", query.getStatus());
        assertNotNull(query.getCreatedDate());
        assertNotNull(query.getResolvedDate());
        assertEquals(user, query.getUser());
    }

    @Test
    void testQueryEntityConstructor() {
        // Create a User object for association
        User user = new User();
        user.setUserid(1L);
        user.setUsername("Test User");

        Date createdDate = new Date();
        Date resolvedDate = new Date();

        Query query = new Query(101L, resolvedDate, createdDate, "Resolved", "Resolution Details", "Query Details", user);

        assertEquals(101L, query.getqueryid());
        assertEquals("Query Details", query.getQueryDetails());
        assertEquals("Resolution Details", query.getQueryResolution());
        assertEquals("Resolved", query.getStatus());
        assertEquals(createdDate, query.getCreatedDate());
        assertEquals(resolvedDate, query.getResolvedDate());
        assertEquals(user, query.getUser());
    }
}
