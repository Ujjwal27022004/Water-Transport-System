package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)  // Use MockitoExtension for unit tests
class BookingRepositoryTest {

    @Mock
    private BookingRepository bookingRepository;

    private Bookings booking;

    @BeforeEach
    void setUp() {
        // Initialize the booking object for testing
        booking = new Bookings();
        booking.setBookingId(1L);
        booking.setSeatsBooked(2);
        booking.setTotalPrice(200);
    }

    @Test
    void testFindByBookingId_Success() {
        // Mock the repository method
        when(bookingRepository.findByBookingId(1L)).thenReturn(booking);

        // Perform the test
        Bookings foundBooking = bookingRepository.findByBookingId(1L);

        assertNotNull(foundBooking, "Booking should be found");
        assertEquals(1L, foundBooking.getBookingId(), "Booking ID should match");
        assertEquals(2, foundBooking.getSeatsBooked(), "Seats booked should match");
        assertEquals(200, foundBooking.getTotalPrice(), "Total price should match");
    }

    @Test
    void testFindByBookingId_Failure() {
        // Mock the repository method to return null
        when(bookingRepository.findByBookingId(2L)).thenReturn(null);

        // Perform the test
        Bookings foundBooking = bookingRepository.findByBookingId(2L);

        assertNull(foundBooking, "Booking should not be found for a non-existing ID");
    }

    @Test
    void testCountBookedSeatsForShip_Success() {
        // Mock the repository method
        when(bookingRepository.countBookedSeatsForShip(1L)).thenReturn(10);

        // Perform the test
        int seatsBooked = bookingRepository.countBookedSeatsForShip(1L);

        assertEquals(10, seatsBooked, "Seats booked for ship should match");
    }

    @Test
    void testCountBookedSeatsForShip_Failure() {
        // Mock the repository method
        when(bookingRepository.countBookedSeatsForShip(2L)).thenReturn(0);

        // Perform the test
        int seatsBooked = bookingRepository.countBookedSeatsForShip(2L);

        assertEquals(0, seatsBooked, "Seats booked for ship should match for non-existing ship");
    }

    @Test
    void testFindByUserId_Success() {
        // Mock the repository method
        when(bookingRepository.findByUser_userid(1L)).thenReturn(booking);

        // Perform the test
        Bookings foundBooking = bookingRepository.findByUser_userid(1L);

        assertNotNull(foundBooking, "Booking should be found by user ID");
        assertEquals(1L, foundBooking.getBookingId(), "Booking ID should match");
    }

    @Test
    void testFindByUserId_Failure() {
        // Mock the repository method to return null
        when(bookingRepository.findByUser_userid(2L)).thenReturn(null);

        // Perform the test
        Bookings foundBooking = bookingRepository.findByUser_userid(2L);

        assertNull(foundBooking, "Booking should not be found for non-existing user ID");
    }
}
