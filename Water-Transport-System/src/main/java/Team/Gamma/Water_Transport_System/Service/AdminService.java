package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;

import java.util.List;

public interface AdminService {
    // Admin Actions
    boolean updateAdmin(AdminDTO admin);
    public Admin getAdmin(Long adminId);
    public List<Admin> getAllAdmin();

}
