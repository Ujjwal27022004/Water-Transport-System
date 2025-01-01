package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends  JpaRepository<Bookings, Long> {
    Bookings findByBookingId(Long bookingId);

    Bookings findByUser_userid(Long userId);
    @Query("SELECT SUM(b.seatsBooked) FROM Bookings b WHERE b.ship.shipId = :shipId")
    Integer countBookedSeatsForShip(@Param("shipId") Long shipId);
}

