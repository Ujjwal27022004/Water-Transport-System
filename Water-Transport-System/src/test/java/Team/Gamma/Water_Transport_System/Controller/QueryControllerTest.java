package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(loginMessage, response.getBody());
        verify(queryService, times(1)).askQuery(userId, queryDTO);
    }
}
