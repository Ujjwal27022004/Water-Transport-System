package Team.Gamma.water_transport_system.Service;


import Team.Gamma.water_transport_system.Dto.QueryDTO;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;

public interface QueryService {
    LoginMessage askQuery(Long userid , QueryDTO queryDTO);
    LoginMessage resolveQuery(Long queryId, String resolutionDetails, String status);
}
