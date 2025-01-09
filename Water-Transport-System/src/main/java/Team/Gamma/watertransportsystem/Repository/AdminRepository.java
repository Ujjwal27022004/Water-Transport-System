package Team.Gamma.watertransportsystem.Repository;

import Team.Gamma.watertransportsystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findOneByEmailAndPassword(String email, String password);
    Admin findByEmail(String email);
}