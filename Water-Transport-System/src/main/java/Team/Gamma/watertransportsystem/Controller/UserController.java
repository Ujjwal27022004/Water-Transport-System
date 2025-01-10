package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Exception.UserNotFoundException;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    private final AdminService adminService;
    @Autowired
    public UserController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    //Signup User and admin
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(path = "/signup")
    public ResponseEntity<Object> signup(@RequestBody UserDTO userDTO) {
        LoginMessage loginResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(loginResponse);
    }
//    Login User and admin

    @PostMapping(path = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(path = "/Admin login")
    public ResponseEntity<Object> adminLogin(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = adminService.loginAdmin(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }



    //profile of User and admin

    @PutMapping("/profile")
    public ResponseEntity<Object> updateProfile(
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
