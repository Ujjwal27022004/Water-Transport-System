package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Dto.ResolutionRequestDTO;
import Team.Gamma.watertransportsystem.Service.QueryService;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
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
