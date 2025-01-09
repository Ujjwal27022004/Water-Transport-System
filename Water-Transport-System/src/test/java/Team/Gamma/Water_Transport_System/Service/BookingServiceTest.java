//package Team.Gamma.Water_Transport_System.Service;
//
//import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
//import Team.Gamma.Water_Transport_System.Entity.Bookings;
//import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
//import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
//import Team.Gamma.Water_Transport_System.Service.impl.Bookingserviceimpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoExtension.class)
//public class BookingServiceTest {
//
//    @Mock
//    private BookingRepository bookingRepository; // Mock BookingRepository
//
//    @InjectMocks
//    private BookingService bookingService; // Inject the service to be tested
//
//    @Mock
//    private BookingDTO bookingDTO; // Mock BookingDTO
//
//    @BeforeEach
//    public void setup() {
//        // Setup the mocks before each test
//    }
//
//    @Test
//    public void makeBooking() {
//        // Create and set up a valid booking object
//        Bookings booking = new Bookings();
//        booking.setSeatsBooked(12);
//        booking.setBookingStatus(BookingStatus.PENDING);
//
//        // Set up the mock BookingDTO values
//        when(bookingDTO.getSeatsBooked()).thenReturn(12);
//        when(bookingDTO.getTotalPrice()).thenReturn(100);  // Example price
//        when(bookingDTO.getUserid()).thenReturn(1L);
//        when(bookingDTO.getShipId()).thenReturn(101L);
//        when(bookingDTO.getBookingStatus()).thenReturn(BookingStatus.PENDING);
//
//        // Convert the BookingDTO to Booking entity
//        booking.setSeatsBooked(bookingDTO.getSeatsBooked());
//        booking.setTotalPrice(bookingDTO.getTotalPrice());
//        booking.setBookingId(bookingDTO.getUserid());
//        booking.setLocalDate(bookingDTO.getLocalDate());
//        booking.setBookingStatus(bookingDTO.getBookingStatus());
//
//        // Set up the mock repository to return the booking when save is called
//        when(bookingRepository.save(any(Bookings.class))).thenReturn(booking);
//
//        // Call the service method to make the booking
//        bookingService.makeBooking(bookingDTO);
//
//        // Verify that the repository save method was called with the correct argument
//        verify(bookingRepository, times(1)).save(any(Bookings.class));  // Check save() was invoked
//
//        // Optionally, assert the behavior to check if booking was saved
//        assertNotNull(booking);  // Ensure the booking is not null
//        assertEquals(12, booking.getSeatsBooked());  // Check if seatsBooked is set correctly
//        assertEquals(BookingStatus.PENDING, booking.getBookingStatus());  // Ensure status is set
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
//        boolean result = bookingService.cancelBooking(1L);
//
//        // Verify the result and interaction with repository
//        assertTrue(result);
//        verify(bookingRepository, times(1)).save(existingBooking);
//    }
//}
