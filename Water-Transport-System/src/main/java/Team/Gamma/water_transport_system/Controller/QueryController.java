package Team.Gamma.water_transport_system.Controller;
;
import Team.Gamma.water_transport_system.Dto.QueryDTO;
import Team.Gamma.water_transport_system.Service.QueryService;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("/*")
@RequestMapping("api/v1/user")
public class QueryController {

    private QueryService queryService;
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }


    //Method is for user to ask query
    @PostMapping("/ask")
    public ResponseEntity<?> askQuery(@RequestParam("userid") Long userid, @RequestBody QueryDTO queryDTO) {
        LoginMessage loginResponse = queryService.askQuery(userid, queryDTO);
        return ResponseEntity.ok(loginResponse);
    }
}