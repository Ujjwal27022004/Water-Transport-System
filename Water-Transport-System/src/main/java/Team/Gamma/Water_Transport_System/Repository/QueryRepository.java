package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Query;
import Team.Gamma.Water_Transport_System.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
    List<Query> findByUser(User user);

}