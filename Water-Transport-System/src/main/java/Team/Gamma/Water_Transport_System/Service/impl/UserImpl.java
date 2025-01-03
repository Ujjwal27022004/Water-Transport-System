package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.UserService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public LoginMessage addUser(UserDTO userDTO) {
        try {
            User user = new User(
                    userDTO.getUserid(),
                    userDTO.getUsername(),
                    userDTO.getEmail(),
                    userDTO.getPassword()
            );
            userRepo.save(user);
            return new LoginMessage("Signup Successfully", true);
        } catch (Exception e) {
            return new LoginMessage("Error during signup: " + e.getMessage(), false);
        }
    }

    UserDTO userDTO;

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        try {
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
                    return new LoginMessage("Password does not match", false);
                }
            } else {
                return new LoginMessage("Email does not exist", false);
            }
        } catch (Exception e) {
            return new LoginMessage("Error during login: " + e.getMessage(), false);
        }
    }

    @Override
    public LoginMessage updateProfile(Long userid, UserDTO request) {
        try {
            User user = userRepo.findByUserid(userid)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userid));

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
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false);
        } catch (Exception e) {
            return new LoginMessage("Error during profile update: " + e.getMessage(), false);
        }
    }

    public User getUserDetails(Long userid) {
        try {
            return userRepo.findByUserid(userid).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user details: " + e.getMessage());
        }
    }
}
