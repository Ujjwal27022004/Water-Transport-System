package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;

import java.util.List;

public interface UserService {
    LoginMessage  addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    LoginMessage updateProfile(Long userid, UserDTO request);
    User getUserDetails(Long userid);

}

