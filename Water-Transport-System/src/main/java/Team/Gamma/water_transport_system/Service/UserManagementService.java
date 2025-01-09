package Team.Gamma.water_transport_system.Service;


import Team.Gamma.water_transport_system.Entity.User;

import java.util.List;

public interface UserManagementService {
    public User searchUser(Long userId);
    public String removeUser(Long userId);
    public String updateUser(User user);
    public List<User> getAllUsers();
}
