package Team.Gamma.Water_Transport_System.Repository;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShipDetailsRepository extends JpaRepository<ShipDetail, Long> {

    @Query("SELECT s FROM ShipDetail s WHERE s.source = :source AND s.destination = :destination")
    List<ShipDetail> searchCruise(@Param("source") String source, @Param("destination") String destination);
    Optional<ShipDetail> findById(Long id);
    Optional<ShipDetail> findByName(String name);

}