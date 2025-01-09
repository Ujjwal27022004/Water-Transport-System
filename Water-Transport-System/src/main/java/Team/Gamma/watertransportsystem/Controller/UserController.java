package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Dto.LoginDTO;
import Team.Gamma.watertransportsystem.Dto.UserDTO;
import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Exception.UserNotFoundException;
import Team.Gamma.watertransportsystem.Service.AdminService;
import Team.Gamma.watertransportsystem.Service.QueryService;
import Team.Gamma.watertransportsystem.Service.UserService;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private QueryService queryService;
    @Autowired
    private AdminService adminService;

    //Signup User and admin
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO) {
        LoginMessage loginResponse = userService.addUser(userDTO);
        return ResponseEntity.ok(loginResponse);
    }
//    Login User and admin

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(path = "/Adminlogin")
    public ResponseEntity<?> Adminlogin(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = adminService.loginAdmin(loginDTO);
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
