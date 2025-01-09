package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Dto.LoginDTO;
import Team.Gamma.water_transport_system.Dto.UserDTO;
import Team.Gamma.water_transport_system.Entity.User;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;

public interface UserService {
    LoginMessage  addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    LoginMessage updateProfile(Long userid, UserDTO request);
    User getUserDetails(Long userid);
}

