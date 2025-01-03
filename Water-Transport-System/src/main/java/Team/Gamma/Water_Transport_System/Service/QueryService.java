package Team.Gamma.Water_Transport_System.Service;


import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;

public interface QueryService {
    LoginMessage askQuery(Long userid , QueryDTO queryDTO);
    LoginMessage resolveQuery(Long queryId, String resolutionDetails, String status);
}
