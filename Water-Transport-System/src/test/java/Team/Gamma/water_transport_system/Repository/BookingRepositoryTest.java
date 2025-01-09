//package Team.Gamma.Water_Transport_System.Repository;
//
//import Team.Gamma.Water_Transport_System.Entity.Bookings;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//public class BookingRepositoryTest {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Test
//    public void testFindByBookingId() {
//        Bookings booking = new Bookings();
//        //booking.setSeatsBooked(2);
//        //booking.setTotalPrice(200);
//        booking = bookingRepository.save(booking);
//
//        Bookings foundBooking = bookingRepository.findByBookingId(booking.getBookingId());
//
//        assertNotNull(foundBooking);
//        assertEquals(booking.getBookingId(), foundBooking.getBookingId());
//    }
//
//    @Test
//    public void testCountBookedSeatsForShip() {
//        Long shipId = 1L; // Use a valid shipId
//        int seatsBooked = bookingRepository.countBookedSeatsForShip(shipId);
//        assertEquals(0, seatsBooked); // Depending on test data, modify assertion
//    }
//}
