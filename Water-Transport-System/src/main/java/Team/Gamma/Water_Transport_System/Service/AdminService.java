package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;

import java.util.List;

public interface AdminService {
    // Admin Actions
    public String addShip(ShipDetail ship);
    public String editShip(ShipDetail ship);
    public String deleteShip(Long shipId);
    boolean updateAdmin(AdminDTO admin);
    public Admin getAdmin(Long adminId);
    public List<Admin> getAllAdmin();
    public LoginMessage loginAdmin(LoginDTO loginDTO);

}
