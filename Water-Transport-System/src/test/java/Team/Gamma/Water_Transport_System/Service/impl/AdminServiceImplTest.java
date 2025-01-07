package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private ShipDetailsRepository shipRepository;


    @InjectMocks
    private AdminServiceImpl adminService;

    private Admin admin;
    private ShipDetail ship;
    private AdminDTO adminDTO;
    private LoginDTO loginDTO;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        admin.setAdminId(1L);
        //admin.setEmail("admin@example.com");
        admin.setPassword("password123");

        ship = new ShipDetail();
        ship.setShipId(1L);
        //ship.setShipName("Ship A");

        adminDTO = new AdminDTO();
        adminDTO.setAdminId(1L);
        adminDTO.setPassword("newPassword");

        loginDTO = new LoginDTO();
        loginDTO.setEmail("admin@example.com");
        loginDTO.setPassword("password123");
    }



    @Test
    void addShip() {
        // Arrange
        ShipDetail ship = new ShipDetail();
        // Mock the save method to return the ship object (if save returns a ShipDetail)
        shipRepository.save(Mockito.any(ShipDetail.class));

        // Act
        String result = adminService.addShip(ship);

        // Assert
        assertEquals("Ship Created Successfully!", result);

        // Verify save was called once with any ShipDetail object
        //verify(shipRepository, times(1)).save(Mockito.any(ShipDetail.class));
    }

    @Test
    void editShip() {
        // Arrange
        ShipDetail ship = new ShipDetail();
        // Mocking save method (assuming it returns a ShipDetail object)
       shipRepository.save(Mockito.any(ShipDetail.class));

        // Act
        String result = adminService.editShip(ship);

        // Assert
        assertEquals("Ship Updated Successfully!", result);

        // Verify that save method was called once
        verify(shipRepository, times(1)).save(Mockito.any(ShipDetail.class));
    }

    @Test
    void deleteShip() {
        // Arrange
        Long shipId = 1L;
        // Mocking deleteById method to do nothing
        doNothing().when(shipRepository).deleteById(Mockito.anyLong());

        // Act
        String result = adminService.deleteShip(shipId);

        // Assert
        assertEquals("Ship Deleted Successfully!", result);

        // Verify that deleteById method was called once with the given shipId
        verify(shipRepository, times(1)).deleteById(Mockito.anyLong());
    }


    @Test
    void updateAdmin() {
        when(adminRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(admin));
        when(adminRepository.save(Mockito.any(Admin.class))).thenReturn(admin);

        boolean result = adminService.updateAdmin(adminDTO);
        assertTrue(result);
        assertEquals("newPassword", admin.getPassword());
    }

    @Test
    void updateAdmin_AdminNotFound() {
        when(adminRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        boolean result = adminService.updateAdmin(adminDTO);
        assertFalse(result);
    }

    @Test
    void getAdmin() {
        when(adminRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(admin));

        Admin result = adminService.getAdmin(1L);
        assertNotNull(result);
        assertEquals(1L, result.getAdminId());
    }

    @Test
    void getAdmin_AdminNotFound() {
        when(adminRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Admin result = adminService.getAdmin(1L);
        assertNull(result);
    }

    @Test
    void getAllAdmin() {
        // Test to return all admins (can be mocked)
        when(adminRepository.findAll()).thenReturn(List.of(admin));

        List<Admin> result = adminService.getAllAdmin();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void loginAdmin_Success() {
        when(adminRepository.findByEmail(Mockito.anyString())).thenReturn(admin);
        when(adminRepository.findOneByEmailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(admin));

        LoginMessage result = adminService.loginAdmin(loginDTO);
        assertEquals("Login Success", result.getMessage());
        assertTrue(result.isSuccess());
    }

    @Test
    void loginAdmin_Fail_WrongPassword() {
        when(adminRepository.findByEmail(Mockito.anyString())).thenReturn(admin);

        LoginMessage result = adminService.loginAdmin(new LoginDTO("admin@example.com", "wrongPassword"));
        assertEquals("Password does not match", result.getMessage());
        assertFalse(result.isSuccess());
    }

    @Test
    void loginAdmin_Fail_EmailNotFound() {
        when(adminRepository.findByEmail(Mockito.anyString())).thenReturn(null);

        LoginMessage result = adminService.loginAdmin(new LoginDTO("unknown@example.com", "password123"));
        assertEquals("Email does not exist", result.getMessage());
        assertFalse(result.isSuccess());
    }

    @Test
    void loginAdmin_Error() {
        when(adminRepository.findByEmail(Mockito.anyString())).thenThrow(new RuntimeException("Database error"));

        LoginMessage result = adminService.loginAdmin(new LoginDTO("admin@example.com", "password123"));
        assertEquals("Error during login: Database error", result.getMessage());
        assertFalse(result.isSuccess());
    }
}
