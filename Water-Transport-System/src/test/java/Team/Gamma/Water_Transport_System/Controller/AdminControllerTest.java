package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import Team.Gamma.Water_Transport_System.Service.AdminService;
import Team.Gamma.Water_Transport_System.Exception.AdminNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    // Test: Fetching details of an admin by ID (Success)
    @Test
    void getAdminDetails_Success() {
        Long adminId = 1L;
        Admin admin = new Admin("John", adminId, "john.doe@example.com");
        when(adminService.getAdmin(adminId)).thenReturn(admin);

        Admin result = adminController.getAdminDetails(adminId);
        assertNotNull(result);
        assertEquals(adminId, result.getAdminId());
        assertEquals("john.doe@example.com", result.getEmailId());
    }

    // Test: Fetching details of an admin by ID (Admin Not Found)
    @Test
    void getAdminDetails_AdminNotFound() {
        Long adminId = 1L;
        when(adminService.getAdmin(adminId)).thenReturn(null);

        AdminNotFoundException exception = assertThrows(AdminNotFoundException.class, () ->
            adminController.getAdminDetails(adminId));
        assertEquals("Admin with ID 1 not found.", exception.getMessage());
    }

    // Test: Fetching all admin details (Success)
    @Test
    void getAllAdminDetails_Success() {
        List<Admin> adminList = new ArrayList<>();
        adminList.add(new Admin("John",1L,  "john.doe@example.com"));
        adminList.add(new Admin("John",2L,  "john.doe@example.com"));
        when(adminService.getAllAdmin()).thenReturn(adminList);

        List<Admin> result = adminController.getAllAdminDetails();
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getAdminId());
    }

    // Test: Fetching all admin details (No Admin Found)
    @Test
    void getAllAdminDetails_NoAdminsFound() {
        when(adminService.getAllAdmin()).thenReturn(new ArrayList<>());

        AdminNotFoundException exception = assertThrows(AdminNotFoundException.class, () -> adminController.getAllAdminDetails());

        assertEquals("No admins found.", exception.getMessage());
    }

    // Test: Updating admin details (Success)
    @Test
    void updateAdminDetails_Success() {
        AdminDTO adminDTO = new AdminDTO();
        when(adminService.updateAdmin(adminDTO)).thenReturn(true);

        String result = adminController.updateAdminDetails(adminDTO);
        assertEquals("Admin details updated successfully!", result);
    }

    // Test: Updating admin details (Admin Not Found)
    @Test
    void updateAdminDetails_AdminNotFound() {
        AdminDTO adminDTO = new AdminDTO( );
        when(adminService.updateAdmin(adminDTO)).thenReturn(false);

        AdminNotFoundException exception = assertThrows(AdminNotFoundException.class, () ->
            adminController.updateAdminDetails(adminDTO));

        assertEquals("Admin with ID "+adminDTO.getAdminId()+" not found for update.", exception.getMessage());
    }

    // Test: Adding a ship (Success)
    @Test
    void addShipDetails_Success() {
        ShipDetail shipDetail = new ShipDetail(1L, "SS Titan", "New York", "London", 7, CruiseType.LUXURY, new Date(), 4.5f, true);

        adminService.addShip(shipDetail);

        String result = adminController.addShipDetails(shipDetail);
        assertEquals("Ship was successfully created", result);
    }

    // Test: Editing a ship (Success)
    @Test
    void editShipDetails_Success() {
        ShipDetail shipDetail = new ShipDetail(1L, "SS Titan", "New York", "London", 7, CruiseType.LUXURY, new Date(), 4.5f, true);
        adminService.editShip(shipDetail);

        String result = adminController.editShipDetails(shipDetail);
        assertEquals("Ship was successfully updated", result);
    }

    // Test: Deleting a ship (Success)
    @Test
    void deleteShipDetails_Success() {
        Long shipId = 1L;
       adminService.deleteShip(shipId);

        String result = adminController.deleteShipDetails(shipId);
        assertEquals("Ship Deleted Successfully", result);
    }
}