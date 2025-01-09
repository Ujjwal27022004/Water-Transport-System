package Team.Gamma.watertransportsystem.Repository;

import Team.Gamma.watertransportsystem.Entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
}