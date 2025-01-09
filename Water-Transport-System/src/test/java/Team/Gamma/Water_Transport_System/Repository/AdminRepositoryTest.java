package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminRepositoryTest {

    @Mock
    private AdminRepository adminRepository;

    private Admin admin;

    @BeforeEach
    void setUp() {
        admin = new Admin();
        admin.setEmailId("admin@example.com");
        admin.setPassword("password123");
    }

    @Test
    void findOneByEmailAndPassword_Success() {
        // Mock the repository method
        when(adminRepository.findOneByEmailAndPassword("admin@example.com", "password123"))
                .thenReturn(Optional.of(admin));

        // Perform the test
        Optional<Admin> foundAdmin = adminRepository.findOneByEmailAndPassword("admin@example.com", "password123");

        assertTrue(foundAdmin.isPresent(), "Admin should be found");
        assertEquals("admin@example.com", foundAdmin.get().getEmailId(), "Email should match");
        assertEquals("password123", foundAdmin.get().getPassword(), "Password should match");
    }

    @Test
    void findOneByEmailAndPassword_Failure() {
        // Mock the repository method to return empty Optional
        when(adminRepository.findOneByEmailAndPassword("wrong@example.com", "wrongpassword"))
                .thenReturn(Optional.empty());

        // Perform the test
        Optional<Admin> foundAdmin = adminRepository.findOneByEmailAndPassword("wrong@example.com", "wrongpassword");

        assertFalse(foundAdmin.isPresent(), "Admin should not be found with incorrect credentials");
    }

    @Test
    void findByEmail_Success() {
        // Mock the repository method
        when(adminRepository.findByEmail("admin@example.com")).thenReturn(admin);

        // Perform the test
        Admin foundAdmin = adminRepository.findByEmail("admin@example.com");

        assertNotNull(foundAdmin, "Admin should be found");
        assertEquals("admin@example.com", foundAdmin.getEmailId(), "Email should match");
    }

    @Test
    void findByEmail_Failure() {
        // Mock the repository method to return null
        when(adminRepository.findByEmail("nonexistent@example.com")).thenReturn(null);

        // Perform the test
        Admin foundAdmin = adminRepository.findByEmail("nonexistent@example.com");

        assertNull(foundAdmin, "Admin should not be found with a non-existing email");
    }
}
