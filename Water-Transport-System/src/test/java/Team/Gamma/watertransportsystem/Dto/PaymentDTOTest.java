package Team.Gamma.watertransportsystem.Dto;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDTOTest {

    @Test
    void testDefaultConstructor() {
        PaymentDTO paymentDTO = new PaymentDTO();
        assertNotNull(paymentDTO, "Default constructor should create a non-null instance");
    }

    @Test
    void testParameterizedConstructor() {
        String message = "Payment successful";
        boolean success = true;

        PaymentDTO paymentDTO = new PaymentDTO(message, success);
        assertEquals(message, paymentDTO.getMessage(), "Message should match the constructor value");
        assertTrue(paymentDTO.isSuccess(), "Success flag should match the constructor value");
    }

    @Test
    void testSettersAndGetters() {
        PaymentDTO paymentDTO = new PaymentDTO();

        // Set values
        paymentDTO.setPaymentId(1L);
        paymentDTO.setBookingId(101L);
        paymentDTO.setMessage("Payment received");
        paymentDTO.setSuccess(true);
        paymentDTO.setPaymentStatus("COMPLETED");
        paymentDTO.setAmount(1500.75);
        Date date = new Date();
        paymentDTO.setDate(date);
        paymentDTO.setPaymentMethod(null); // Using null or a mock value for PaymentMethod

        // Assert values
        assertEquals(1L, paymentDTO.getPaymentId(), "Payment ID should match the set value");
        assertEquals(101L, paymentDTO.getBookingId(), "Booking ID should match the set value");
        assertEquals("Payment received", paymentDTO.getMessage(), "Message should match the set value");
        assertTrue(paymentDTO.isSuccess(), "Success flag should match the set value");
        assertEquals("COMPLETED", paymentDTO.getPaymentStatus(), "Payment status should match the set value");
        assertEquals(1500.75, paymentDTO.getAmount(), "Amount should match the set value");
        assertEquals(date, paymentDTO.getDate(), "Date should match the set value");
        assertNull(paymentDTO.getPaymentMethod(), "Payment method should be null as set");
    }
}
