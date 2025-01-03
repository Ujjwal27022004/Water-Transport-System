package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    Optional<User> findOneByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    Optional<User> findByUserid(Long userid);
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    User searchUser(@Param("userId") Long userId);
}

