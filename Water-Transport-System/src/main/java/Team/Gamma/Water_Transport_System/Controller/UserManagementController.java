package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermanagement")
public class UserManagementController {

    private final UserManagementService userManagementService;

    @Autowired
    public UserManagementController(UserManagementService user) {
        this.userManagementService = user;
    }
    @GetMapping("/search")
    public User getUserDetailsById(

            @RequestParam("userId") Long userId) {
        return userManagementService.searchUser(userId);
    }
    @GetMapping
    public List<User> getAllUsers(){
        return userManagementService.getAllUsers();
    }
    @PutMapping
    public String editUser(@RequestBody User user){
    userManagementService.updateUser(user);
    return "User updated Successfully!";
    }
    @DeleteMapping("{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        userManagementService.removeUser(userId);
        return "User Deleted Successfully";
    }
}