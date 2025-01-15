//package Team.Gamma.Water_Transport_System.Controller;
//
//import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
//import Team.Gamma.Water_Transport_System.Entity.Payment;
//import Team.Gamma.Water_Transport_System.Enum.PaymentMethod;
//import Team.Gamma.Water_Transport_System.Exception.PaymentException;
//import Team.Gamma.Water_Transport_System.Service.impl.PaymentServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class PaymentControllerTest {
//
//   @Mock
//   private PaymentServiceImpl paymentService;
//
//   @InjectMocks
//   private PaymentController paymentController;
//
//   private Payment testPayment;
//
//   @BeforeEach
//   void setUp() {
//      testPayment = new Payment();
//      testPayment.setPaymentID(1L);
//      testPayment.setBookingID(101L);
//      testPayment.setAmount(100.0);
//      testPayment.setDate(new Date());
//      testPayment.setPaymentMethod(PaymentMethod.NETBANKING);
//      testPayment.setPaymentStatus("INITIATED");
//   }
//
//   @Test
//   void testInitiatePayment_Success() {
//      // Arrange
//      when(paymentService.initiatePayment(anyLong(), anyDouble())).thenReturn(testPayment);
//
//      // Act
//      ResponseEntity<Payment> response = paymentController.initiatePayment(101L, 100.0);
//
//      // Assert
//      assertNotNull(response);
//      assertEquals(200, response.getStatusCodeValue());
//      assertEquals(testPayment, response.getBody());
//      verify(paymentService, times(1)).initiatePayment(101L, 100.0);
//   }
//
//   @Test
//   void testInitiatePayment_Failure() {
//      // Arrange
//      when(paymentService.initiatePayment(anyLong(), anyDouble())).thenReturn(null);
//
//      // Act & Assert
//      PaymentException exception = assertThrows(PaymentException.class, () -> paymentController.initiatePayment(101L, 100.0));
//      assertEquals("Failed to initiate payment", exception.getMessage());
//      verify(paymentService, times(1)).initiatePayment(101L, 100.0);
//   }
//
//   @Test
//   void testConfirmPayment_Success() {
//      // Arrange
//      PaymentDTO paymentDTO = new PaymentDTO("Payment is successful.", true);
//      when(paymentService.confirmPayment(anyLong())).thenReturn(paymentDTO);
//
//      // Act
//      ResponseEntity response = paymentController.confirmPayment(1L);
//
//      // Assert
//      assertNotNull(response);
//      assertEquals(200, response.getStatusCodeValue());
//      assertEquals(paymentDTO, response.getBody());
//      verify(paymentService, times(1)).confirmPayment(1L);
//   }
//
//   @Test
//   void testConfirmPayment_Failure() {
//      // Arrange
//      PaymentDTO paymentDTO = new PaymentDTO("Payment not found or already processed.", false);
//      when(paymentService.confirmPayment(anyLong())).thenReturn(paymentDTO);
//
//      // Act
//      ResponseEntity response = paymentController.confirmPayment(1L);
//
//      // Assert
//      assertNotNull(response);
//      assertEquals(400, response.getStatusCodeValue());
//      assertEquals(paymentDTO, response.getBody());
//      verify(paymentService, times(1)).confirmPayment(1L);
//   }
//
//   @Test
//   void testHandlePaymentException() {
//      // Act
//      ResponseEntity<String> response = paymentController.handlePaymentException(new PaymentException("Test exception"));
//
//      // Assert
//      assertNotNull(response);
//      assertEquals(400, response.getStatusCodeValue());
//      assertEquals("Test exception", response.getBody());
//   }
//}
