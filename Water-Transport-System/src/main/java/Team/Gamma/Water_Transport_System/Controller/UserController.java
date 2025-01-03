package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.QueryDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Exception.UserNotFoundException;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.Service.QueryService;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QueryService queryService;
    @Autowired
    private AdminService adminService;

    //Signup User and admin
    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        LoginMessage loginResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(loginResponse);
    }
//    Login User and admin
@CrossOrigin(origins = "http://localhost:5174")

@PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("Received login request: " + loginDTO);
        LoginMessage loginResponse = adminService.loginAdmin(loginDTO);
        if (loginResponse != null && loginResponse.getStatus()) {
            System.out.println("Admin login successful");
            return ResponseEntity.ok(loginResponse);
        }

        loginResponse = userService.loginUser(loginDTO);
        if (loginResponse != null && loginResponse.getStatus()) {
            System.out.println("User login successful");
            return ResponseEntity.ok(loginResponse);
        }

        System.out.println("Invalid credentials for both admin and user");
        return ResponseEntity.badRequest().body(new LoginMessage("Invalid credentials for both admin and user.", false));
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
