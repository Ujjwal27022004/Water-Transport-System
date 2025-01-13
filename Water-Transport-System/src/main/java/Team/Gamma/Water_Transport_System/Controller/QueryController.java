package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getQueries")
    public ResponseEntity<?> getQueriesByUserId(@RequestParam("userid") Long userid) {
        try {
            List<QueryDTO> queries = queryService.getQueriesByUserId(userid);
            return ResponseEntity.ok(queries); // Return the list of queries with HTTP 200
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error fetching queries: " + e.getMessage()); // Handle user not found or other runtime exceptions
        }
    }
}