package Team.Gamma.water_transport_system.Service.impl;
import Team.Gamma.water_transport_system.Dto.QueryDTO;
import Team.Gamma.water_transport_system.Entity.Query;
import Team.Gamma.water_transport_system.Entity.User;
import Team.Gamma.water_transport_system.Repository.QueryRepository;
import Team.Gamma.water_transport_system.Repository.UserRepository;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QueryImplTest {

    @InjectMocks
    private QueryImpl queryImpl;

    @Mock
    private QueryRepository queryRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    void testAskQuery_Success() {
        Long userId = 1L;
        User user = new User();
        user.setUserid(userId);

        QueryDTO queryDTO = new QueryDTO("Test Query");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        LoginMessage expectedMessage = new LoginMessage("Query successfully Submitted!", true);
        LoginMessage actualMessage = queryImpl.askQuery(userId, queryDTO);

        assertEquals(expectedMessage.getMessage(), actualMessage.getMessage());
        assertTrue(actualMessage.isStatus());
        verify(queryRepository, times(1)).save(any(Query.class));
    }

    @Test
    void testResolveQuery_Success() {
        Long queryId = 1L;
        Query query = new Query();
        query.setqueryid(queryId);

        when(queryRepository.findById(queryId)).thenReturn(Optional.of(query));

        LoginMessage expectedMessage = new LoginMessage("Query resolved successfully!", true);
        LoginMessage actualMessage = queryImpl.resolveQuery(queryId, "Resolution details", "Resolved");

        assertEquals(expectedMessage.getMessage(), actualMessage.getMessage());
        assertTrue(actualMessage.isStatus());
        verify(queryRepository, times(1)).save(query);
    }

    @Test
    void testResolveQuery_QueryNotFound() {
        Long queryId = 99L;

        when(queryRepository.findById(queryId)).thenReturn(Optional.empty());

        LoginMessage actualMessage = queryImpl.resolveQuery(queryId, "Resolution details", "Resolved");

        assertFalse(actualMessage.isStatus());
        assertEquals("Query not found with ID: " + queryId, actualMessage.getMessage());
    }
}
