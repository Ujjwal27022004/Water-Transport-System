//package Team.Gamma.Water_Transport_System.Service;
//
//import Team.Gamma.Water_Transport_System.Dto.AdminDTO;
//import Team.Gamma.Water_Transport_System.Dto.LoginDTO;
//import Team.Gamma.Water_Transport_System.Entity.Admin;
//import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
//import Team.Gamma.Water_Transport_System.Repository.AdminRepository;
//import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
//import Team.Gamma.Water_Transport_System.Service.impl.AdminServiceImpl;
//import Team.Gamma.Water_Transport_System.payload.response.LoginMessage;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.*;
//
//class AdminServiceTest {
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @Mock
//    private ShipDetailsRepository shipDetailRepository;
//
//
//
//    @InjectMocks
//    private AdminServiceImpl adminService;
//
//    private Admin admin;
//    private AdminDTO adminDTO;
//    private LoginDTO loginDTO;
//    private ShipDetail shipDetail;
//
//    private Long adminId = 1L;
//    private Long shipId = 101L;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        // Initialize test data
//        admin = new Admin();
//        admin.setAdminId(adminId);
//        //admin.setUsername("adminUser");
//        admin.setPassword("adminPass");
//        //admin.setEmail("admin@example.com");
//
//        adminDTO = new AdminDTO();
//        //adminDTO.setUsername("adminUpdated");
//        //adminDTO.setEmail("adminUpdated@example.com");
//        adminDTO.setPassword("newAdminPass");
//
//        loginDTO = new LoginDTO();
//        loginDTO.setEmail("admin@example.com");
//        loginDTO.setPassword("adminPass");
//
//        shipDetail = new ShipDetail();
//        shipDetail.setShipId(shipId);
//        //shipDetail.setShipName("Ship A");
//    }
//
////    @Test
////    void addShip() {
////        // Given
////        shipDetailRepository.save(shipDetail);
////
////        // When
////        String result = adminService.addShip(shipDetail);
////
////        // Then
////        assertEquals("Ship added successfully", result);
////    }
//
////    @Test
////    void editShip() {
////        // Given
////        shipDetailRepository.save(shipDetail);
////
////        // When
////        String result = adminService.editShip(shipDetail);
////
////        // Then
////        assertEquals("Ship updated successfully", result);
////    }
//
////    @Test
////    void deleteShip() {
////        // Given
////        willDoNothing().given(shipDetailRepository).deleteById(shipId);
////
////        // When
////        String result = adminService.deleteShip(shipId);
////
////        // Then
////        assertEquals("Ship deleted successfully", result);
////    }
//
//    @Test
//    void updateAdmin() {
//        // Given
//        given(adminRepository.save(any(Admin.class))).willReturn(admin);
//
//        // When
//        boolean result = adminService.updateAdmin(adminDTO);
//
//        // Then
//        assertTrue(result);
//    }
//
//    @Test
//    void getAdmin() {
//        // Given
//        given(adminRepository.findById(adminId)).willReturn(Optional.of(admin));
//
//        // When
//        Admin result = adminService.getAdmin(adminId);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(adminId, result.getAdminId());
//    }
//
//    @Test
//    void getAllAdmin() {
//        // Given
//        Admin admin2 = new Admin();
//        admin2.setAdminId(2L);
//        //admin2.setUsername("admin2");
//        admin2.setPassword("adminPass2");
//        //admin2.setEmail("admin2@example.com");
//
//        given(adminRepository.findAll()).willReturn(Arrays.asList(admin, admin2));
//
//        // When
//        var result = adminService.getAllAdmin();
//
//        // Then
//        assertNotNull(result);
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    void loginAdmin_Success() {
//        // Given
//        LoginMessage loginMessage = new LoginMessage("Login Success", true);
//        given(adminRepository.findByEmail(loginDTO.getEmail()));
//
//        // When
//        LoginMessage result = adminService.loginAdmin(loginDTO);
//
//        // Then
//        assertEquals("Login Success", result.getMessage());
////        assertTrue(result.isSuccess());
//    }
//
//    @Test
//    void loginAdmin_Fail_InvalidPassword() {
//        // Given
//        loginDTO.setPassword("wrongPassword");
//        LoginMessage loginMessage = new LoginMessage("Invalid password", false);
//        given(adminRepository.findByEmail(loginDTO.getEmail()));
//
//        // When
//        LoginMessage result = adminService.loginAdmin(loginDTO);
//
//        // Then
//        assertEquals("Invalid password", result.getMessage());
////        assertFalse(result.isSuccess());
//    }
//
//    @Test
//    void loginAdmin_Fail_EmailNotFound() {
//        // Given
//        given(adminRepository.findByEmail(loginDTO.getEmail()));
//
//        // When
//        LoginMessage result = adminService.loginAdmin(loginDTO);
//
//        // Then
//        assertEquals("Email not found", result.getMessage());
////        assertFalse(result.isSuccess());
//    }
//}
