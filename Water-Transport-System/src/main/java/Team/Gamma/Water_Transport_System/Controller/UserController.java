package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Exception.UserNotFoundException;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QueryService queryService;

    //Signup User and admin
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        LoginMessage loginResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(loginResponse);
    }


    //profile of User and admin

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @RequestParam("userid") Long userid,
            @RequestBody UserDTO request) {
        LoginMessage loginResponse = userService.updateProfile(userid, request);
        return ResponseEntity.ok(loginResponse);
    }

    //User details

    @GetMapping("/details")
    public User getUserDetails(@RequestParam("userid") Long userid) {
        User user = userService.getUserDetails(userid);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userid);
        }
        return user;
    }

}
