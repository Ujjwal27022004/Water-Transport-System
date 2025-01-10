package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.Receipt;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  // Ensure mocks are initialized
 class ReceiptServiceImplTest {

    @Mock
    private UserImpl userService;

    @Mock
    private Bookingserviceimpl bookingService;

    @InjectMocks
    private ReceiptServiceImpl receiptService;  // Inject mocks into the service

    @Mock
    private ReceiptRepository receiptRepository;  // Mock the ReceiptRepository

    @BeforeTestMethod
    public void setup() {
        // Initialize mocks before each test method
    }

    // Positive Test 1: Generate Receipt with Valid User ID
    @Test
    public void testGenerateReceiptWithValidUserId() {
        Long userId = 1L;
        User validUser = new User();
        validUser.setUserid(userId);

        Bookings booking = new Bookings();
        booking.setTotalPrice(1000);
        booking.setShip(new ShipDetail());

        Receipt mockReceipt = new Receipt();
        mockReceipt.setReceiptId(1L); // Set a valid ID
        mockReceipt.setAmount(1000);

        // Mocking service calls
        when(userService.getUserDetails(userId)).thenReturn(validUser);
        when(bookingService.getLatestBookingByUserId(userId)).thenReturn(booking);
        when(receiptRepository.save(any(Receipt.class))).thenReturn(mockReceipt); // Mock save

        // Generate receipt
        ReceiptDTO receiptDTO = receiptService.generateReceipt(userId);

        // Assert results
        assertNotNull(receiptDTO, "Generated ReceiptDTO should not be null");
        assertEquals(validUser.getUserid(), receiptDTO.getUser().getUserid(), "User ID mismatch");
        assertEquals(booking.getTotalPrice(), receiptDTO.getAmount(), "Amount mismatch");
        assertEquals(booking.getShip(), receiptDTO.getShip(), "Ship details mismatch");
    }

    // Negative Test 1: Invalid User ID (User Not Found)
    @Test
    public void testInvalidUserId() {
        Long invalidUserId = 999L;

        // Mocking the service to return null for invalid user
        when(userService.getUserDetails(invalidUserId)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            receiptService.generateReceipt(invalidUserId);
        });
        assertEquals("Invalid data provided", exception.getMessage());
    }

    // Negative Test 2: Invalid Booking for User
    @Test
    public void testInvalidBookingForUser() {
        Long userId = 999L;
        User validUser = new User();
        validUser.setUserid(userId);

        // Mocking user service and booking service
        when(userService.getUserDetails(userId)).thenReturn(validUser);
        when(bookingService.getLatestBookingByUserId(userId)).thenReturn(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            receiptService.generateReceipt(userId);
        });
        assertEquals("Invalid data provided", exception.getMessage());
    }

    // Negative Test 3: Null or Invalid Ship Details
//    @Test
//    public void testNullShipDetails() {
//        Long userId = 1L;
//        User validUser = new User();
//        validUser.setUserid(userId);
//
//        Bookings booking = new Bookings();
//        booking.setTotalPrice(1000);
//        booking.setShip(null);  // Simulate null ship details
//
//        // Mocking the services
//        when(userService.getUserDetails(userId)).thenReturn(validUser);
//        when(bookingService.getLatestBookingByUserId(userId)).thenReturn(booking);
//
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            receiptService.generateReceipt(userId);
//        });
//        assertEquals("Ship details are missing", exception.getMessage());
//    }

    // Boundary Test: Zero Amount in Booking
    @Test
    public void testZeroAmountInBooking() {
        Long userId = 1L;
        User validUser = new User();
        validUser.setUserid(userId);

        Bookings booking = new Bookings();
        booking.setTotalPrice(0);  // Zero amount
        booking.setShip(new ShipDetail());

        // Mocking the services
        when(userService.getUserDetails(userId)).thenReturn(validUser);
        when(bookingService.getLatestBookingByUserId(userId)).thenReturn(booking);

        // Mocking save() method to return a Receipt object with a valid receiptId
        Receipt mockReceipt = new Receipt();
        mockReceipt.setReceiptId(1L);  // Set a valid receiptId

        when(receiptRepository.save(any())).thenReturn(mockReceipt);  // Ensure the save method returns this mock

        // Generate receipt
        ReceiptDTO receiptDTO = receiptService.generateReceipt(userId);

        // Validate the receipt
        assertNotNull(receiptDTO, "Generated ReceiptDTO should not be null");
        assertEquals(1L, receiptDTO.getReceiptId(), "Receipt ID mismatch");
        assertEquals(0, receiptDTO.getAmount(), "Amount should be zero");
    }

    // Boundary Test: Generate Receipt with Future Date
//    @Test
//    public void testGenerateReceiptWithFutureDate() {
//        Long userId = 1L;
//        User validUser = new User();
//        validUser.setUserid(userId);
//
//        Bookings booking = new Bookings();
//        booking.setTotalPrice(1000);
//        booking.setShip(new ShipDetail());
//
//        // Mocking the services
//        when(userService.getUserDetails(userId)).thenReturn(validUser);
//        when(bookingService.getLatestBookingByUserId(userId)).thenReturn(booking);
//
//        // Mocking the save() method of the receiptRepository to return a valid receipt
//        Receipt mockReceipt = new Receipt();
//        mockReceipt.setReceiptId(1L);  // Set a valid receiptId
//        mockReceipt.setDate(new Date());  // Set the current date or any valid date
//
//        when(receiptRepository.save(any())).thenReturn(mockReceipt);  // Ensure the save method returns this mock
//
//        // Generate receipt
//        ReceiptDTO receiptDTO = receiptService.generateReceipt(userId);
//
//        // Validate the receipt
//        assertNotNull(receiptDTO, "Generated ReceiptDTO should not be null");
//        assertNotNull(receiptDTO.getDate(), "Date should not be null");
//        assertTrue(receiptDTO.getDate().before(new Date()), "Receipt date should not be in the future");
//    }

}
