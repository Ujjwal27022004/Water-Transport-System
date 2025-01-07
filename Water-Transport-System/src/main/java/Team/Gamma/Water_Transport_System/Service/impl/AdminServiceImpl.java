package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ShipDetailsRepository shipRepository;


    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public String addShip(ShipDetail ship) {
        shipRepository.save(ship);
        return "Ship Created Successfully!";
    }
    // function to edit ship in DB
    @Override
    public String editShip(ShipDetail ship) {
        shipRepository.save(ship);
        return "Ship Updated Successfully!";
    }
    // function to delete ship in DB
    @Override
    public String deleteShip(Long shipId) {
        shipRepository.deleteById(shipId);
        return "Ship Deleted Successfully!";
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


    @Override
    public LoginMessage loginAdmin(LoginDTO loginDTO) {
        try {
            String msg = "";
            Admin admin = adminRepository.findByEmail(loginDTO.getEmail());
            if (admin != null) {
                String password = loginDTO.getPassword();
                String encodedPassword = admin.getPassword();

                if (password.equals(encodedPassword)) {
                    Optional<Admin> employee = adminRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                    if (employee.isPresent()) {
                        return new LoginMessage("Login Success", true);
                    } else {
                        return new LoginMessage("Login Failed", false);
                    }
                } else {
                    return new LoginMessage("Password does not match", false);
                }
            } else {
                return new LoginMessage("Email does not exist", false);
            }
        } catch (Exception e) {
            return new LoginMessage("Error during login: " + e.getMessage(), false);
        }
    }
}
