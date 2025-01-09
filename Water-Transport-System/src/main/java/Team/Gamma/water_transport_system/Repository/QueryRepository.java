package Team.Gamma.water_transport_system.Repository;

import Team.Gamma.water_transport_system.Entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
}