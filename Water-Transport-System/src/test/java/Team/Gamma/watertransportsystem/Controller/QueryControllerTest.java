package Team.Gamma.watertransportsystem.Controller;
import Team.Gamma.watertransportsystem.Service.QueryService;
import Team.Gamma.watertransportsystem.Dto.QueryDTO;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QueryControllerTest {

    @InjectMocks
    private QueryController queryController;

    @Mock
    private QueryService queryService;

    @Test
    void testAskQuery() {
        Long userId = 1L;
        QueryDTO queryDTO = new QueryDTO("Test Query");

        LoginMessage loginMessage = new LoginMessage("Query successfully submitted!", true);
        when(queryService.askQuery(userId, queryDTO)).thenReturn(loginMessage);

        ResponseEntity<?> response = queryController.askQuery(userId, queryDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(loginMessage, response.getBody());
        verify(queryService, times(1)).askQuery(userId, queryDTO);
    }

    @Test
    void testAskQueryWithInvalidInput() {
        Long userId = 1L;

        // Act
        ResponseEntity<?> response = queryController.askQuery(userId, null);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()); // Ensure BAD_REQUEST is returned
        assertEquals("Invalid userId or empty query", response.getBody()); // Ensure the error message is in the response body
        verify(queryService, never()).askQuery(any(), any()); // Ensure the service is not called
    }

    @Test
    void testAskQueryWithEdgeCases() {
        Long userId = 0L;  // Invalid user ID
        QueryDTO queryDTO = new QueryDTO("");  // Empty query string

        // Act
        ResponseEntity<?> response = queryController.askQuery(userId, queryDTO);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());  // Ensure BAD_REQUEST is returned
        assertEquals("Invalid userId or empty query", response.getBody());  // Ensure the error message is in the response body
        verify(queryService, never()).askQuery(any(), any());  // Ensure the service is not called
    }



}
