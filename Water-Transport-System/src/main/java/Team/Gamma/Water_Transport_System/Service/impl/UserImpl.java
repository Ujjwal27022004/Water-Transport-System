package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UpdateUserDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public LoginMessage addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getuserId(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword()
        );
        userRepo.save(user);
        return new LoginMessage("Signup Successfully", true);
    }
    UserDTO userDTO;
    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();

            if (password.equals(encodedPassword)) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }

    @Override
    public LoginMessage updateProfile(Long userId, UpdateUserDTO request) {
        User user = userRepo.findByuserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getEmail() != null) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null) {
            user.setPassword(request.getPassword()); // Ensure password is encrypted
        }

        userRepo.save(user);
        return new LoginMessage("Profile Updated Successfully", true);

    }

    public User getUserDetails(Long userId) {
        // Retrieve the user by userId
        return userRepo.findByuserId(userId).orElse(null);
    }

}
