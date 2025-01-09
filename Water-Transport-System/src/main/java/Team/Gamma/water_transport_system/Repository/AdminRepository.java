package Team.Gamma.water_transport_system.Repository;

import Team.Gamma.water_transport_system.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findOneByEmailAndPassword(String email, String password);
    Admin findByEmail(String email);
}