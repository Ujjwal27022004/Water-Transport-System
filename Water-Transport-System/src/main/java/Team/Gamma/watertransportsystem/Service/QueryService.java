package Team.Gamma.watertransportsystem.Service;


import Team.Gamma.watertransportsystem.Dto.QueryDTO;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;

public interface QueryService {
    LoginMessage askQuery(Long userid , QueryDTO queryDTO);
    LoginMessage resolveQuery(Long queryId, String resolutionDetails, String status);
}
