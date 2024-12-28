package Team.Gamma.Water_Transport_System.Controller;


import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admindetails")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    // function for fetching details of admin from DB
    @GetMapping("/{adminId}")
    public Admin getAdminDetails(@PathVariable("adminId") Long adminId) {
        return adminService.getAdmin(adminId);
    }
    // function for fetching details of all admin from DB
    @GetMapping
    public List<Admin> getAllAdminDetails() {
        return adminService.getAllAdmin();
    }

    // function for updating details of admin in DB
    @PutMapping
    public String updateAdminDetails(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return "AdminDetails updated successfully!";
    }
}

