package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Exception.AdminNotFoundException;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/admindetails")
public class AdminController {

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    private final AdminService adminService;

    // function for fetching details of admin from DB
    @GetMapping("/{adminId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public Admin getAdminDetails(@PathVariable("adminId") Long adminId) {
        Admin admin = adminService.getAdmin(adminId);
        if (admin == null) {
            throw new AdminNotFoundException("Admin with ID " + adminId + " not found.");
        }
        return admin;
    }

    // function for fetching details of all admins from DB
    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Admin> getAllAdminDetails() {
        List<Admin> admins = adminService.getAllAdmin();
        if (admins == null || admins.isEmpty()) {
            throw new AdminNotFoundException("No admins found.");
        }
        return admins;
    }

    // function for updating details of admin in DB
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/adminedit")
    public String updateAdminDetails(@RequestBody AdminDTO admin) {
        boolean isUpdated = adminService.updateAdmin(admin); // Expecting a boolean return type
        if (!isUpdated) {
            throw new AdminNotFoundException("Admin with ID " + admin.getAdminId() + " not found for update.");
        }
        return "Admin details updated successfully!";
    }



    @PostMapping("/Shipadd")
    @CrossOrigin(origins = "http://localhost:5173")
    public String addShipDetails(@RequestBody ShipDetail ship) {
        adminService.addShip(ship);
        return "Ship was successfully created";
    }

    //This method is for updating details of ship
    @PutMapping("/Shipedit")
    @CrossOrigin(origins = "http://localhost:5173")
    public String editShipDetails(@RequestBody ShipDetail ship) {
        adminService.editShip(ship);
        return "Ship was successfully updated";
    }


}