package Team.Gamma.Water_Transport_System.Repository;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShipDetailsRepository extends JpaRepository<ShipDetail, Long> {

    /**
     * Custom query method to search for cruises based on source and destination.
     *
     * @param source      The starting location of the cruise.
     * @param destination The ending location of the cruise.
     * @return A list of ShipDetail objects that match the given source and destination.
     */
    @Query("SELECT s FROM ShipDetail s WHERE s.source = :source AND s.destination = :destination")
    List<ShipDetail> searchCruise(@Param("source") String source, @Param("destination") String destination);
}