package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UpdateUser;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")

public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody UserDTO userDTO)
    {
        LoginMessage loginResponse =  userService.addUser(userDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logout successful!";
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @RequestParam("userId") Long userId,
            @RequestBody UpdateUser request) {
        LoginMessage loginResponse = userService.updateProfile(userId, request);
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping("/details")
    public User getUserDetails(@RequestParam("userId") Long userId) {
        // Fetch the current user's details from the UserService
        return userService.getUserDetails(userId);
    }

}

