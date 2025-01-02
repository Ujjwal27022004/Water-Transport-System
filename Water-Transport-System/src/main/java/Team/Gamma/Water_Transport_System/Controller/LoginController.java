package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        LoginMessage loginResponse = adminService.loginAdmin(loginDTO);
        if (loginResponse != null && loginResponse.getStatus()) {
            return ResponseEntity.ok(loginResponse);
        }

        loginResponse = userService.loginUser(loginDTO);
        if (loginResponse != null && loginResponse.getStatus()) {
            return ResponseEntity.ok(loginResponse);
        }

        return ResponseEntity.badRequest().body(new LoginMessage("Invalid credentials for both admin and user.", false));
    }

    @PostMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "Logout successful!";
    }
}
