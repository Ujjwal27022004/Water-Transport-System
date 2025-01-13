package Team.Gamma.Water_Transport_System.Service;


import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;

import java.util.List;

public interface QueryService {
    List<QueryDTO> getAllQueries();

    LoginMessage askQuery(Long userid , QueryDTO queryDTO);
    LoginMessage resolveQuery(Long queryId, String resolutionDetails, String status);
<<<<<<< HEAD
}
=======
    List<QueryDTO> getQueriesByUserId(Long userid);
}
>>>>>>> 6f5380ce1086296b93c73bdd59a99e9edbe7446f
