package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.ResolutionRequestDTO;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/query-resolution")
public class QueryResolvenceController {

    @Autowired
    private QueryService queryService;

    @PutMapping("/{queryId}/resolve")
    public LoginMessage resolveQuery(@PathVariable Long queryId,
                                     @RequestBody ResolutionRequestDTO resolutionRequest) {
        return queryService.resolveQuery(queryId, resolutionRequest.getResolutionDetails(), resolutionRequest.getStatus());
    }
}
