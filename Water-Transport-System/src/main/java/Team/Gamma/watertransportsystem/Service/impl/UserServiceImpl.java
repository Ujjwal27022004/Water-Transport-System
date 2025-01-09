package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.Repository.UserRepository;
import Team.Gamma.watertransportsystem.Service.UserManagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserManagementService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User searchUser(Long userId) {
       return userRepository.searchUser(userId);
    }

    @Override
    public String removeUser(Long userId) {
        userRepository.deleteById(userId);
        return "User Removed Successfully!";
    }
    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "User updated Successfully!";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
