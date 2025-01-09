package Team.Gamma.water_transport_system.Controller;

import Team.Gamma.water_transport_system.Dto.ResolutionRequestDTO;
import Team.Gamma.water_transport_system.Service.QueryService;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/query-resolution")
public class QueryResolvenceController {

    private QueryService queryService;
    public QueryResolvenceController(QueryService queryService) {
        this.queryService = queryService;
    }

    //Method is for admin to resolve queries of users
    @PutMapping("/{queryId}/resolve")
    public LoginMessage resolveQuery(@PathVariable Long queryId,
                                     @RequestBody ResolutionRequestDTO resolutionRequest) {
        return queryService.resolveQuery(queryId, resolutionRequest.getResolutionDetails(), resolutionRequest.getStatus());
    }
}
