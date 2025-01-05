package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Exception.AdminNotFoundException;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admindetails")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // function for fetching details of admin from DB
    @GetMapping("/{adminId}")
    public Admin getAdminDetails(@PathVariable("adminId") Long adminId) {
        Admin admin = adminService.getAdmin(adminId);
        if (admin == null) {
            throw new AdminNotFoundException("Admin with ID " + adminId + " not found.");
        }
        return admin;
    }

    // function for fetching details of all admins from DB
    @GetMapping
    public List<Admin> getAllAdminDetails() {
        List<Admin> admins = adminService.getAllAdmin();
        if (admins == null || admins.isEmpty()) {
            throw new AdminNotFoundException("No admins found.");
        }
        return admins;
    }

    // function for updating details of admin in DB
    @PutMapping
    public String updateAdminDetails(@RequestBody AdminDTO admin) {
        boolean isUpdated = adminService.updateAdmin(admin); // Expecting a boolean return type
        if (!isUpdated) {
            throw new AdminNotFoundException("Admin with ID " + admin.getAdminId() + " not found for update.");
        }
        return "Admin details updated successfully!";
    }



@PostMapping("/Shipadd")
public String addShipDetails(@RequestBody ShipDetail ship) {
    adminService.addShip(ship);
    return "Ship was successfully created";
}

//This method is for updating details of ship
@PutMapping("/Shipedit")
public String editShipDetails(@RequestBody ShipDetail ship) {
    adminService.editShip(ship);
    return "Ship was successfully updated";
}

//This method is for deleting ship
@DeleteMapping("/delete/{shipId}")
public String deleteShipDetails(@PathVariable("shipId") Long shipId) {
    adminService.deleteShip(shipId);
    return "Ship Deleted Successfully";
}
}
