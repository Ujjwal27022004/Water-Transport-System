package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
import Team.Gamma.Water_Transport_System.Entity.Admin;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.impl.AdminServiceImpl;
import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class AdminServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private ShipDetailsRepository shipDetailRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    private Admin admin;
    private AdminDTO adminDTO;
    private LoginDTO loginDTO;
    private ShipDetail shipDetail;

    private Long adminId = 1L;
    private Long shipId = 101L;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adminService = new AdminServiceImpl(adminRepository, shipDetailRepository);


        admin = new Admin();
        admin.setAdminId(adminId);
        admin.setPassword("adminPass");

        adminDTO = new AdminDTO();
        adminDTO.setAdminId(adminId);
        adminDTO.setPassword("newAdminPass");

        loginDTO = new LoginDTO();
        loginDTO.setEmail("admin@example.com");
        loginDTO.setPassword("adminPass");

        shipDetail = new ShipDetail();
        shipDetail.setShipId(shipId);
    }

    @Test
    void addShip() {
        shipDetail.setCruiseType(CruiseType.FAMILY); // Setting cruise type for pricing
        shipDetail.setPrice(0); // Initially, price is not set

        given(shipDetailRepository.save(shipDetail)).willReturn(shipDetail);

        String result = adminService.addShip(shipDetail);

        assertEquals("Ship Created Successfully!", result);
        assertEquals(800f, shipDetail.getPrice(), 0.01); // Verify price is set correctly for FAMILY
        then(shipDetailRepository).should(times(1)).save(shipDetail);
    }

    @Test
    void editShip() {
        shipDetail.setCruiseType(CruiseType.LUXURY); // Setting cruise type for pricing
        shipDetail.setPrice(0); // Initially, price is not set

        given(shipDetailRepository.save(shipDetail)).willReturn(shipDetail);

        String result = adminService.editShip(shipDetail);

        assertEquals("Ship Updated Successfully!", result);
        assertEquals(2000f, shipDetail.getPrice(), 0.01); // Verify price is set correctly for LUXURY
        then(shipDetailRepository).should(times(1)).save(shipDetail);
    }


    @Test
    void deleteShip() {
        willDoNothing().given(shipDetailRepository).deleteById(shipId);

        String result = adminService.deleteShip(shipId);

        assertEquals("Ship Deleted Successfully!", result);
        then(shipDetailRepository).should(times(1)).deleteById(shipId);
    }

    @Test
    void updateAdmin() {
        given(adminRepository.findById(adminId)).willReturn(Optional.of(admin));

        boolean result = adminService.updateAdmin(adminDTO);

        assertTrue(result);
        then(adminRepository).should(times(1)).save(any(Admin.class));
    }

    @Test
    void updateAdmin_AdminNotFound() {
        given(adminRepository.findById(adminId)).willReturn(Optional.empty());

        boolean result = adminService.updateAdmin(adminDTO);

        assertFalse(result);
        then(adminRepository).should(never()).save(any(Admin.class));
    }

    @Test
    void getAdmin() {
        given(adminRepository.findById(adminId)).willReturn(Optional.of(admin));

        Admin result = adminService.getAdmin(adminId);

        assertNotNull(result);
        assertEquals(adminId, result.getAdminId());
    }

    @Test
    void getAllAdmin() {
        Admin admin2 = new Admin();
        admin2.setAdminId(2L);
        admin2.setPassword("adminPass2");

        given(adminRepository.findAll()).willReturn(Arrays.asList(admin, admin2));

        var result = adminService.getAllAdmin();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void loginAdmin_Success() {
        given(adminRepository.findByEmail(loginDTO.getEmail())).willReturn(admin);
        given(adminRepository.findOneByEmailAndPassword(loginDTO.getEmail(), admin.getPassword()))
                .willReturn(Optional.of(admin));

        LoginMessage result = adminService.loginAdmin(loginDTO);

        assertTrue(result.isStatus());
        assertEquals("Login Success", result.getMessage());
    }

    @Test
    void loginAdmin_EmailNotFound() {
        given(adminRepository.findByEmail(loginDTO.getEmail())).willReturn(null);

        LoginMessage result = adminService.loginAdmin(loginDTO);

        assertFalse(result.isStatus());
        assertEquals("Email does not exist", result.getMessage());
    }

    @Test
    void loginAdmin_InvalidPassword() {
        given(adminRepository.findByEmail(loginDTO.getEmail())).willReturn(admin);

        loginDTO.setPassword("wrongPass");

        LoginMessage result = adminService.loginAdmin(loginDTO);

        assertFalse(result.isStatus());
        assertEquals("Password does not match", result.getMessage());
    }
}
