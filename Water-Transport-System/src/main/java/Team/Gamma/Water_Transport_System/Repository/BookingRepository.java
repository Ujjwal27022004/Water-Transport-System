package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends  JpaRepository<Bookings, Long> {

}
