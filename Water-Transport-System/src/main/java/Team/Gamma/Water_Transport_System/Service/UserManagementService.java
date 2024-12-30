package Team.Gamma.Water_Transport_System.Service;


import Team.Gamma.Water_Transport_System.Entity.User;

import java.util.List;

public interface UserManagementService {
    public User searchUser(Long userId);
    public String removeUser(Long userId);
    public String updateUser(User user);
    public List<User> getAllUsers();
}
