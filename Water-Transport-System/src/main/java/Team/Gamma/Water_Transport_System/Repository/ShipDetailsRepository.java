package Team.Gamma.Water_Transport_System.Repository;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipDetailsRepository extends JpaRepository<ShipDetail, Long> {
}