package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Exception.UserNotFoundException;
import Team.Gamma.Water_Transport_System.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usermanagement")
public class UserManagementController {

    private final UserManagementService userManagementService;
    @Autowired
    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    //search user (admin)
    @GetMapping("/search")
    public User getUserDetailsById(@RequestParam("userId") Long userId) {
        User user = userManagementService.searchUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found with ID: " + userId);
        }
        return user;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userManagementService.getAllUsers();
    }


//    edit user
    @PutMapping
    public String editUser(@RequestBody User user) {
        userManagementService.updateUser(user);
        return "User updated Successfully!";
    }


}
