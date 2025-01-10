package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Enum.PaymentMethod;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.PaymentRepository;
import Team.Gamma.Water_Transport_System.Repository.PassengerDetailsRepository;
import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PassengerDetailsRepository passengerDetailsRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
        // Clean up if needed
    }

    @Test
    void initiatePayment_validAmount() {
        Long bookingId = 1L;
        double amount = 100.0;

        // Mocking booking repository to return a booking when findByBookingId is called
        Bookings mockBooking = new Bookings();
        mockBooking.setBookingId(bookingId);
        mockBooking.setBookingStatus(BookingStatus.PENDING);
        when(bookingRepository.findByBookingId(bookingId)).thenReturn(mockBooking);

        // When and then
        Payment payment = paymentService.initiatePayment(bookingId, amount);

        assertNotNull(payment);
        assertEquals(BookingStatus.BOOKED, mockBooking.getBookingStatus());
        assertEquals(amount, payment.getAmount());
        assertEquals("PENDING", payment.getPaymentStatus());
        verify(bookingRepository, times(1)).findByBookingId(bookingId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    // Function to initiate payment
    public Payment initiatePayment(Long bookingId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        Optional<Bookings> booking = Optional.ofNullable(bookingRepository.findByBookingId(bookingId));

        if (booking.isPresent()) {
            // Create a new Payment with "pending" status
            Bookings bookings = booking.get();
            bookings.setBookingStatus(BookingStatus.BOOKED);
            Payment payment = new Payment();
            payment.setBookingID(bookings.getBookingId());
            payment.setPaymentMethod(PaymentMethod.NETBANKING);
            payment.setAmount(amount);
            payment.setDate(new java.util.Date());
            payment.setPaymentStatus("PENDING");

            paymentRepository.save(payment);

            return payment;
        } else {
            return null;
        }
    }


    @Test
    void confirmPayment_success() {
        Long paymentId = 1L;

        // Mocking Payment and Booking
        Payment mockPayment = new Payment();
        mockPayment.setPaymentStatus("PENDING");
        mockPayment.setBookingID(1L);
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(mockPayment));

        Bookings mockBooking = new Bookings();
        mockBooking.setBookingId(1L);
        mockBooking.setSeatsBooked(0);
        when(bookingRepository.findByBookingId(1L)).thenReturn(mockBooking);
        when(passengerDetailsRepository.countByBookingId(1L)).thenReturn(3L); // Assuming 3 passengers

        // When
        PaymentDTO response = paymentService.confirmPayment(paymentId);

        // Then
        assertTrue(response.isSuccess());
        assertEquals("Payment is successful.", response.getMessage());
        verify(paymentRepository, times(1)).save(any(Payment.class));
        verify(bookingRepository, times(1)).save(mockBooking);
    }

    @Test
    void confirmPayment_paymentNotFound() {
        Long paymentId = 999L; // Non-existent payment ID

        // Mocking Payment repository to return empty Optional
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        // When
        PaymentDTO response = paymentService.confirmPayment(paymentId);

        // Then
        assertFalse(response.isSuccess());
        assertEquals("Payment not found or already processed.", response.getMessage());
        verify(paymentRepository, never()).save(any(Payment.class));
    }
}
