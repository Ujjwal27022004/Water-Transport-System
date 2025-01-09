package Team.Gamma.watertransportsystem.Service;

import Team.Gamma.watertransportsystem.Dto.LoginDTO;
import Team.Gamma.watertransportsystem.Dto.UserDTO;
import Team.Gamma.watertransportsystem.Entity.User;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;

public interface UserService {
    LoginMessage  addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    LoginMessage updateProfile(Long userid, UserDTO request);
    User getUserDetails(Long userid);
}

