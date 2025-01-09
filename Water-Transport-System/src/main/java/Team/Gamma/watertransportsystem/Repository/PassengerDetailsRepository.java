package Team.Gamma.watertransportsystem.Repository;

import Team.Gamma.watertransportsystem.Entity.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {
    long countByBookingId(Long bookingId);

}
