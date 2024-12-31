package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
    // Custom Query methods can be added here if needed
}