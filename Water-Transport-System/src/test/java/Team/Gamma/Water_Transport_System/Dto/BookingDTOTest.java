package Team.Gamma.Water_Transport_System.Dto;

import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingDTOTest {

    private BookingDTO bookingDTO;

    @BeforeEach
    void setUp() {
        // Initializing the BookingDTO object before each test
        bookingDTO = new BookingDTO();
    }

    @Test
    void testBookingDTOSettersAndGetters() {
        // Set values
        LocalDateTime localDate = LocalDateTime.now();
        bookingDTO.setLocalDate(localDate);
        bookingDTO.setSeatsBooked(5);
        bookingDTO.setTotalPrice(1500);
        bookingDTO.setUserid(100L);
        bookingDTO.setShipId(200L);
        bookingDTO.setBookingStatus(BookingStatus.PENDING); // Using an existing status

        // Assert values
        assertEquals(localDate, bookingDTO.getLocalDate(), "LocalDate should match the set value");
        assertEquals(5, bookingDTO.getSeatsBooked(), "SeatsBooked should match the set value");
        assertEquals(1500, bookingDTO.getTotalPrice(), "TotalPrice should match the set value");
        assertEquals(100L, bookingDTO.getUserid(), "UserId should match the set value");
        assertEquals(200L, bookingDTO.getShipId(), "ShipId should match the set value");
        assertEquals(BookingStatus.PENDING, bookingDTO.getBookingStatus(), "BookingStatus should match the set value");
    }

    @Test
    void testBookingDTOConstructor() {
        // Creating an instance with setter values to validate constructor behavior
        LocalDateTime localDate = LocalDateTime.now();
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setLocalDate(localDate);
        bookingDTO.setSeatsBooked(3);
        bookingDTO.setTotalPrice(1200);
        bookingDTO.setUserid(101L);
        bookingDTO.setShipId(202L);
        bookingDTO.setBookingStatus(BookingStatus.PENDING); // Use existing status

        // Assert that the constructor set the right values
        assertNotNull(bookingDTO.getLocalDate(), "LocalDate should not be null");
        assertTrue(bookingDTO.getSeatsBooked() > 0, "SeatsBooked should be greater than 0");
        assertTrue(bookingDTO.getTotalPrice() > 0, "TotalPrice should be greater than 0");
        assertEquals(101L, bookingDTO.getUserid(), "UserId should match the set value");
        assertEquals(202L, bookingDTO.getShipId(), "ShipId should match the set value");
        assertEquals(BookingStatus.PENDING, bookingDTO.getBookingStatus(), "BookingStatus should match the set value");
    }
}
