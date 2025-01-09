package Team.Gamma.watertransportsystem.Service;


import Team.Gamma.watertransportsystem.Entity.User;

import java.util.List;

public interface UserManagementService {
    public User searchUser(Long userId);
    public String removeUser(Long userId);
    public String updateUser(User user);
    public List<User> getAllUsers();
}
