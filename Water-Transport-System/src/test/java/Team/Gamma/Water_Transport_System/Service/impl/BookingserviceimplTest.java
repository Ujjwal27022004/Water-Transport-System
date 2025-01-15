package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Exception.BookingNotFoundException;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookingserviceimplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ShipDetailsService shipDetailsService;

    @InjectMocks
    private Bookingserviceimpl bookingserviceimpl;

    private User user;
    private ShipDetail shipDetail;
    private BookingDTO bookingDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserid(1L);

        shipDetail = new ShipDetail();
        shipDetail.setShipId(1L);

        bookingDTO = new BookingDTO();
        bookingDTO.setUserid(1L);
        bookingDTO.setShipId(1L);
        bookingDTO.setSeatsBooked(2);
        bookingDTO.setLocalDate(LocalDateTime.now());
    }

    @AfterEach
    void tearDown() {
        // Cleanup logic if needed
    }

    @Test
    void makeBooking_ShouldThrowException_WhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingserviceimpl.makeBooking(bookingDTO);
        });
        assertEquals("User not found with ID: 1", exception.getMessage());
    }


    @Test
    void cancelBooking_ShouldThrowException_WhenBookingNotFound() {
        when(bookingRepository.findById(1L)).thenReturn(Optional.empty());

        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingserviceimpl.cancelBooking(1L);
        });
        assertEquals("Booking not found with ID: 1", exception.getMessage());
    }


    @Test
    void getLatestBookingByUserId_ShouldThrowException_WhenNoBookingExists() {
        when(bookingRepository.findByUser_userid(1L)).thenReturn(null);

        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingserviceimpl.getLatestBookingByUserId(1L);
        });
        assertEquals("No bookings found for user ID: 1", exception.getMessage());
    }


    @Test
    void getBookingsByUserid_ShouldThrowException_WhenUserNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        BookingNotFoundException exception = assertThrows(BookingNotFoundException.class, () -> {
            bookingserviceimpl.getBookingsByUserid(1L);
        });
        assertEquals("User not found with ID: 1", exception.getMessage());
    }
}
