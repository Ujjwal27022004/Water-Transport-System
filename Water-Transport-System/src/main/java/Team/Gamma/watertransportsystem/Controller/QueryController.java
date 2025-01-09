package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Dto.QueryDTO;
import Team.Gamma.watertransportsystem.Service.QueryService;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class QueryController {

    private QueryService queryService;
    public QueryController(QueryService queryService) {
        this.queryService = queryService;
    }



    //Method is for user to ask query
    @PostMapping("/ask")
    public ResponseEntity<?> askQuery(@RequestParam("userid") Long userid, @RequestBody QueryDTO queryDTO) {
        if (userid <= 0 || queryDTO == null || queryDTO==null) {
            return ResponseEntity.badRequest().body("Invalid userId or empty query");
        }
        LoginMessage loginResponse = queryService.askQuery(userid, queryDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
