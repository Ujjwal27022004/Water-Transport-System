package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Exception.AdminNotFoundException;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

}
