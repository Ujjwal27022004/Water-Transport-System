//package Team.Gamma.Water_Transport_System.Repository;
//import Team.Gamma.Water_Transport_System.Entity.Query;
//import Team.Gamma.Water_Transport_System.Entity.User;
//import Team.Gamma.Water_Transport_System.Repository.QueryRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class QueryRepositoryTest {
//
//    @Autowired
//    private QueryRepository queryRepository;
//
//    @Test
//    void testSaveQuery() {
//        // Create a User object for association
//        User user = new User();
//        user.setUserid(1L);  // Simulate a user ID
//        user.setUsername("Test User");
//
//        // Create a Query object
//        Query query = new Query();
//        query.setQueryDetails("Sample Query Details");
//        query.setQueryResolution("Pending");
//        query.setStatus("Open");
//        query.setCreatedDate(new Date());
//        query.setUser(user);
//
//        // Save the query
//        Query savedQuery = queryRepository.save(query);
//
//        // Verify the saved query
//        assertNotNull(savedQuery.getqueryid());
//        assertEquals("Sample Query Details", savedQuery.getQueryDetails());
//        assertEquals("Pending", savedQuery.getQueryResolution());
//        assertEquals("Open", savedQuery.getStatus());
//        assertNotNull(savedQuery.getCreatedDate());
//        assertEquals(user, savedQuery.getUser());
//    }
//
//    @Test
//    void testFindById() {
//        // Create and save a Query object
//        Query query = new Query();
//        query.setQueryDetails("Find Me");
//        query.setQueryResolution("Pending");
//        query.setStatus("Open");
//        query.setCreatedDate(new Date());
//        Query savedQuery = queryRepository.save(query);
//
//        // Retrieve by ID
//        Optional<Query> retrievedQuery = queryRepository.findById(savedQuery.getqueryid());
//
//        // Verify the retrieved query
//        assertTrue(retrievedQuery.isPresent());
//        assertEquals("Find Me", retrievedQuery.get().getQueryDetails());
//    }
//
//    @Test
//    void testFindAllQueries() {
//        // Create and save multiple Query objects
//        Query query1 = new Query();
//        query1.setQueryDetails("Query 1");
//        query1.setQueryResolution("Pending");
//        query1.setStatus("Open");
//        query1.setCreatedDate(new Date());
//
//        Query query2 = new Query();
//        query2.setQueryDetails("Query 2");
//        query2.setQueryResolution("Resolved");
//        query2.setStatus("Closed");
//        query2.setCreatedDate(new Date());
//
//        queryRepository.save(query1);
//        queryRepository.save(query2);
//
//        // Retrieve all queries
//        List<Query> queries = queryRepository.findAll();
//
//        // Verify the results
//        assertEquals(2, queries.size());
//    }
//
//    @Test
//    void testDeleteQuery() {
//        // Create and save a Query object
//        Query query = new Query();
//        query.setQueryDetails("To Be Deleted");
//        query.setQueryResolution("Pending");
//        query.setStatus("Open");
//        query.setCreatedDate(new Date());
//        Query savedQuery = queryRepository.save(query);
//
//        // Delete the query
//        queryRepository.deleteById(savedQuery.getqueryid());
//
//        // Verify the deletion
//        Optional<Query> deletedQuery = queryRepository.findById(savedQuery.getqueryid());
//        assertFalse(deletedQuery.isPresent());
//    }
//}
