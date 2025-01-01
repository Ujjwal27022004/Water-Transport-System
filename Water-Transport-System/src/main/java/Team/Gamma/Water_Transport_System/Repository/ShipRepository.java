package Team.Gamma.Water_Transport_System.Repository;
import Team.Gamma.Water_Transport_System.Entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    /**
     * Custom query method to search for cruises based on source and destination.
     *
     * @param source      The starting location of the cruise.
     * @param destination The ending location of the cruise.
     * @return A list of ShipDetail objects that match the given source and destination.
     */
    @Query("SELECT s FROM ShipDetail s WHERE s.source = :source AND s.destination = :destination")
    List<Ship> searchCruise(@Param("source") String source, @Param("destination") String destination);
    Optional<Ship> findById(Long id);
    Optional<Ship> findByName(String name);

}