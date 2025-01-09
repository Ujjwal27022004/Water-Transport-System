package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Service.impl.Bookingserviceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private Bookingserviceimpl bookingserviceimpl; // Inject the service for testing

    @Mock
    private BookingDTO bookingDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

//    @Test
//    void makeBooking() {
//        // Prepare the BookingDTO object
//        bookingDTO.setBookingStatus(BookingStatus.BOOKED);
//
//        // Create a Booking entity based on the DTO
//        Bookings booking = new Bookings();
//        booking.setBookingStatus(BookingStatus.BOOKED);
//        // Set other necessary fields in the entity as required
//        // Example: booking.setSeatsBooked(5); booking.setTotalPrice(100);
//
//        // Mock the behavior of the repository to return the booking entity when save is called
//        when(bookingRepository.save(any(Bookings.class))).thenReturn(booking);
//
//        // Call the method to be tested
//        bookingserviceimpl.makeBooking(bookingDTO);
//
//        // Verify that save() method was called on the repository with a non-null argument
//        verify(bookingRepository, times(1)).save(any(Bookings.class));
//    }
//
//    @Test
//    void cancelBooking() {
//        // Mock the behavior of bookingRepository.findByBookingId() and save()
//        Bookings existingBooking = new Bookings();
//        existingBooking.setBookingStatus(BookingStatus.PENDING);
//
//        when(bookingRepository.findByBookingId(anyLong())).thenReturn(existingBooking);
//        when(bookingRepository.save(any(Bookings.class))).thenReturn(existingBooking);
//
//        // Call the method to be tested
//        boolean result = bookingserviceimpl.cancelBooking(1L);
//
//        // Verify the result and interaction with repository
//        assertTrue(result);
//        verify(bookingRepository, times(1)).save(existingBooking);
//    }
}
