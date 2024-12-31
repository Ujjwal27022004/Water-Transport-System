package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;


    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // function to update admin details
    @Override
    public String updateAdmin(AdminDTO admin) {
        Admin saveAdmin = new Admin();
        saveAdmin.setAdminId(admin.getAdminId());
        saveAdmin.setPassword(admin.getPassword());
        adminRepository.save(saveAdmin);
        return "Updated Successfully!";
    }

    // function to fetch admin details using id from DB
    @Override
    public Admin getAdmin(Long adminId) {
        return adminRepository.findById(adminId).get();
    }
    // function to fetch admin details from DB
    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }
}