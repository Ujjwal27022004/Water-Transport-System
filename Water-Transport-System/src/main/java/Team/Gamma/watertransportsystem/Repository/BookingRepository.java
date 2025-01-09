package Team.Gamma.watertransportsystem.Repository;

import Team.Gamma.watertransportsystem.Entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends  JpaRepository<Bookings, Long> {
    Bookings findByBookingId(Long bookingId);

    Bookings findByUser_userid(Long userId);
    @Query("SELECT COALESCE(SUM(b.seatsBooked), 0) FROM Bookings b WHERE b.ship.shipId = :shipId")
    int countBookedSeatsForShip(@Param("shipId") Long shipId);

}

