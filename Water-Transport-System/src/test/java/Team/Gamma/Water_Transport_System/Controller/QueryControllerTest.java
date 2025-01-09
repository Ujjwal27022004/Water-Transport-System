package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
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

        ResponseEntity<?> response = queryController.askQuery(userId, null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode()); // Assuming the controller handles this as Bad Request
        verify(queryService, never()).askQuery(any(), any()); // Ensure the service is not called
    }
    @Test
    void testAskQueryWithEdgeCases() {
        Long userId = 0L;
        QueryDTO queryDTO = new QueryDTO("");

        LoginMessage loginMessage = new LoginMessage("Invalid query", false);
        when(queryService.askQuery(userId, queryDTO)).thenReturn(loginMessage);

        ResponseEntity<?> response = queryController.askQuery(userId, queryDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(loginMessage, response.getBody());
        verify(queryService, times(1)).askQuery(userId, queryDTO);
    }


}
