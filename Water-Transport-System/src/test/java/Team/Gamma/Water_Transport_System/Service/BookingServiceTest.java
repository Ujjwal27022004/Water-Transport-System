package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingService bookingService;  // Use concrete class here

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private BookingDTO bookingDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    void makeBooking() {
        // Mock the behavior of bookingRepository.save()
        bookingRepository.save(any(Bookings.class));

        // Create a BookingDTO and set necessary fields for the test
//        bookingDTO.setSeatsBooked(5);
//        bookingDTO.setTotalPrice(100);
        bookingDTO.setBookingStatus(BookingStatus.BOOKED);

        // Call the method to be tested
        bookingService.makeBooking(bookingDTO);

        // Verify that save() method was called on the repository
        verify(bookingRepository, times(1)).save(any(Bookings.class));
    }

    @Test
    void cancelBooking() {
        // Mock the behavior of bookingRepository.findByBookingId() and save()
        Bookings existingBooking = new Bookings();
        existingBooking.setBookingStatus(BookingStatus.PENDING);

        when(bookingRepository.findByBookingId(anyLong())).thenReturn(existingBooking);
        when(bookingRepository.save(any(Bookings.class))).thenReturn(existingBooking);

        // Call the method to be tested
        boolean result = bookingService.cancelBooking(1L);

        // Verify the result and interaction with repository
        assertTrue(result);
        verify(bookingRepository, times(1)).save(existingBooking);
    }
}
