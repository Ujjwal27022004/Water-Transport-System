package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // function to update admin details
    @Override
    public boolean updateAdmin(AdminDTO admin) {
        Optional<Admin> existingAdmin = adminRepository.findById(admin.getAdminId());
        if (existingAdmin.isPresent()) {
            Admin saveAdmin = existingAdmin.get();
            saveAdmin.setPassword(admin.getPassword());
            adminRepository.save(saveAdmin);
            return true;
        }
        return false; // Return false if the admin does not exist
    }

    // function to fetch admin details using id from DB
    @Override
    public Admin getAdmin(Long adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    // function to fetch all admin details from DB
    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }
}
