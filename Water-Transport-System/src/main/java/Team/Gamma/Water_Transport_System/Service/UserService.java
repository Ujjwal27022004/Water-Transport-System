package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;

public interface UserService {
    User addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    User getUserDetails(Long userid);
}

