package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Dto.AdminDTO;
import Team.Gamma.water_transport_system.Dto.LoginDTO;
import Team.Gamma.water_transport_system.Entity.Admin;
import Team.Gamma.water_transport_system.Entity.ShipDetail;
import Team.Gamma.water_transport_system.payload.response.LoginMessage;

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
