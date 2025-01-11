package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
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
        try {
            User user = new User(
                    userDTO.getUserid(),
                    userDTO.getUsername(),
                    userDTO.getEmail(),
                    userDTO.getPassword()
            );
            userRepo.save(user);
            return new LoginMessage("Signup Successfully", true, "user", user.getUserid());
        } catch (Exception e) {
            return new LoginMessage("Error during signup: " + e.getMessage(), false, "user", null);
        }
    }

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        try {
            User user1 = userRepo.findByEmail(loginDTO.getEmail());
            if (user1 != null) {
                String password = loginDTO.getPassword();
                String encodedPassword = user1.getPassword();

                if (password.equals(encodedPassword)) {
                    Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                    if (employee.isPresent()) {
                        // Include the userId in the response when login is successful
                        return new LoginMessage("Login Success", true, "user", employee.get().getUserid());
                    } else {
                        return new LoginMessage("Login Failed", false, "user", null); // Return null for userId if login fails
                    }
                } else {
                    return new LoginMessage("Password does not match", false, "user", null); // Return null for userId if password doesn't match
                }
            } else {
                return new LoginMessage("Email does not exist", false, "user", null); // Return null for userId if email doesn't exist
            }
        } catch (Exception e) {
            return new LoginMessage("Error during login: " + e.getMessage(), false, "user", null); // Return null for userId in case of an exception
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
            return new LoginMessage("Profile Updated Successfully", true, "user", user.getUserid());
        } catch (RuntimeException e) {
            return new LoginMessage(e.getMessage(), false, "user", null);
        } catch (Exception e) {
            return new LoginMessage("Error during profile update: " + e.getMessage(), false, "user", null);
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
