package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Dto.ResolutionRequestDTO;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query-resolution")
public class QueryResolvenceController {

    private final QueryService queryService;
    @Autowired
    public QueryResolvenceController(QueryService queryService) {
        this.queryService = queryService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getquery")
    public List<QueryDTO> getAllQueries() {
        return queryService.getAllQueries();
    }


    //Method is for admin to resolve queries of users
    @PutMapping("/resolve/{queryId}")
    public LoginMessage resolveQuery(@PathVariable Long queryId,
                                     @RequestBody ResolutionRequestDTO resolutionRequest) {
        return queryService.resolveQuery(queryId, resolutionRequest.getResolutionDetails(), resolutionRequest.getStatus());
    }
}
