package Team.Gamma.watertransportsystem.Service;

import Team.Gamma.watertransportsystem.Dto.AdminDTO;
import Team.Gamma.watertransportsystem.Dto.LoginDTO;
import Team.Gamma.watertransportsystem.Entity.Admin;
import Team.Gamma.watertransportsystem.Entity.ShipDetail;
import Team.Gamma.watertransportsystem.payload.response.LoginMessage;

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
