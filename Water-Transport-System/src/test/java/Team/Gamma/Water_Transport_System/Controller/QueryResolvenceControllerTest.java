package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Dto.ResolutionRequestDTO;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QueryResolvenceControllerTest {

    @InjectMocks
    private QueryResolvenceController queryResolvenceController;

    @Mock
    private QueryService queryService;

    @Test
    void testResolveQuery() {
        Long queryId = 1L;
        ResolutionRequestDTO resolutionRequest = new ResolutionRequestDTO();

        LoginMessage loginMessage = new LoginMessage("Query resolved successfully!", true,"admin");
        when(queryService.resolveQuery(queryId, resolutionRequest.getResolutionDetails(), resolutionRequest.getStatus()))
                .thenReturn(loginMessage);

        LoginMessage response = queryResolvenceController.resolveQuery(queryId, resolutionRequest);

        assertEquals("Query resolved successfully!", response.getMessage());
        assertTrue(response.isStatus());
        verify(queryService, times(1)).resolveQuery(queryId, resolutionRequest.getResolutionDetails(), resolutionRequest.getStatus());
    }
}
