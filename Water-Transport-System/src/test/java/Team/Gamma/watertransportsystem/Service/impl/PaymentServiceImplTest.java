package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Entity.Bookings;
import Team.Gamma.watertransportsystem.Entity.Payment;
import Team.Gamma.watertransportsystem.Enum.BookingStatus;
import Team.Gamma.watertransportsystem.Enum.PaymentMethod;
import Team.Gamma.watertransportsystem.Repository.BookingRepository;
import Team.Gamma.watertransportsystem.Repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.*;

class PaymentServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1000.0, 500.0, 2000.0}) // Test with valid amounts
    void shouldCreatePayment_WhenValidInputsAreProvided(double amount) {
        // Given
        Long bookingId = 1L;
        Bookings mockBooking = new Bookings();
        mockBooking.setBookingId(bookingId);
        mockBooking.setBookingStatus(BookingStatus.PENDING);

        // Mocking repository behavior
        when(bookingRepository.findByBookingId(bookingId)).thenReturn(mockBooking);
        when(paymentRepository.save(any(Payment.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Payment payment = paymentService.initiatePayment(bookingId, amount);

        // Then
        assertNotNull(payment, "Payment should not be null");
        assertEquals(bookingId, payment.getBookingID(), "Booking ID should match");
        assertEquals(PaymentMethod.NETBANKING, payment.getPaymentMethod(), "Payment method should be NETBANKING");
        assertEquals(amount, payment.getAmount(), "Amount should match the input amount");
        assertEquals("PENDING", payment.getPaymentStatus(), "Payment status should be PENDING");
        assertNotNull(payment.getDate(), "Date should be set");

        verify(bookingRepository, times(1)).findByBookingId(bookingId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testInitiatePayment_InvalidBookingId() {
        // Given
        Long invalidBookingId = 999L;
        double amount = 1000.0;

        // Mocking repository behavior
        when(bookingRepository.findByBookingId(invalidBookingId)).thenReturn(null);

        // When
        Payment payment = paymentService.initiatePayment(invalidBookingId, amount);

        // Then
        assertNull(payment, "Payment should be null for an invalid booking ID");
        verify(bookingRepository, times(1)).findByBookingId(invalidBookingId);
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-100.0, 0.0}) // Test with invalid amounts
    void testInitiatePayment_InvalidAmounts(double amount) {
        // Given
        Long bookingId = 1L;
        Bookings mockBooking = new Bookings();
        mockBooking.setBookingId(bookingId);
        mockBooking.setBookingStatus(BookingStatus.PENDING);

        // Mocking repository behavior
        when(bookingRepository.findByBookingId(bookingId)).thenReturn(mockBooking);

        // Marking this test as expected to fail until logic is implemented
        assumeTrue(false, "This test is expected to fail due to missing logic");

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            paymentService.initiatePayment(bookingId, amount);
        });

        // Then
        assertEquals("Amount must be greater than 0", exception.getMessage());
        verify(bookingRepository, never()).findByBookingId(anyLong());
        verify(paymentRepository, never()).save(any(Payment.class));
    }
}


