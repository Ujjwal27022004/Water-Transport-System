package Team.Gamma.water_transport_system.Repository;

import Team.Gamma.water_transport_system.Entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {
    long countByBookingId(Long bookingId);

}
