package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService {

    private static final Map<CruiseType, Float> PRICING_STRATEGY = Map.of(
            CruiseType.FAMILY, 800f,
            CruiseType.DELUXE, 1200f,
            CruiseType.LUXURY, 2000f,
            CruiseType.PREMIUM, 1500f
    );


    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ShipDetailsRepository shipRepository;

    public AdminServiceImpl(AdminRepository adminRepository, ShipDetailsRepository shipDetailsRepository) {
        this.adminRepository = adminRepository;
        this.shipRepository = shipDetailsRepository;
    }

    @Override
    public String addShip(ShipDetail ship) {
        setPriceBasedOnCruiseType(ship);
        shipRepository.save(ship);
        return "Ship Created Successfully!";
    }

    @Override
    public String editShip(ShipDetail ship) {
        setPriceBasedOnCruiseType(ship);
        shipRepository.save(ship);
        return "Ship Updated Successfully!";
    }

    @Override
    public String deleteShip(Long shipId) {
        shipRepository.deleteById(shipId);
        return "Ship Deleted Successfully!";
    }

    @Override
    public boolean updateAdmin(AdminDTO admin) {
        Optional<Admin> existingAdmin = adminRepository.findById(admin.getAdminId());
        if (existingAdmin.isPresent()) {
            Admin saveAdmin = existingAdmin.get();
            saveAdmin.setPassword(admin.getPassword());
            adminRepository.save(saveAdmin);
            return true;
        }
        return false;
    }

    @Override
    public Admin getAdmin(Long adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

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
                        return new LoginMessage("Login Success", true, "admin");
                    } else {
                        return new LoginMessage("Login Failed", false, "admin");
                    }
                } else {
                    return new LoginMessage("Password does not match", false, "admin");
                }
            } else {
                return new LoginMessage("Email does not exist", false, "admin");
            }
        } catch (Exception e) {
            return new LoginMessage("Error during login: " + e.getMessage(), false, "admin");
        }
    }

    private void setPriceBasedOnCruiseType(ShipDetail ship) {
        if (PRICING_STRATEGY.containsKey(ship.getCruiseType())) {
            ship.setPrice(PRICING_STRATEGY.get(ship.getCruiseType()));
        } else {
            throw new IllegalArgumentException("Invalid cruise type: " + ship.getCruiseType());
        }
    }
}
