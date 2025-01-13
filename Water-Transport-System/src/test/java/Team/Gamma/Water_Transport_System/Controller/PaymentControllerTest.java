//package Team.Gamma.Water_Transport_System.Controller;
//
//import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
//import Team.Gamma.Water_Transport_System.Entity.Payment;
//import Team.Gamma.Water_Transport_System.Service.impl.PaymentServiceImpl;
//import Team.Gamma.Water_Transport_System.Exception.PaymentException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(PaymentController.class)
//@AutoConfigureMockMvc(addFilters = false)
// class PaymentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PaymentServiceImpl paymentService;
//
//    @Test
//     void testInitiatePayment_Success() throws Exception {
//        Payment mockPayment = new Payment();
//        mockPayment.setPaymentID(1L);
//        mockPayment.setAmount(1000.0);
//        mockPayment.setPaymentStatus("INITIATED");
//
//        when(paymentService.initiatePayment(1L, 1000.0)).thenReturn(mockPayment);
//
//        mockMvc.perform(post("/payments/initiate")
//                        .param("bookingId", "1")
//                        .param("amount", "1000.0")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // Updated to 200 OK
//                .andExpect(jsonPath("$.paymentID").value(1))
//                .andExpect(jsonPath("$.amount").value(1000.0))
//                .andExpect(jsonPath("$.paymentStatus").value("INITIATED"));
//
//        verify(paymentService, times(1)).initiatePayment(1L, 1000.0);
//    }
//
//    @Test
//    void testInitiatePayment_Failure() throws Exception {
//        when(paymentService.initiatePayment(1L, 1000.0)).thenThrow(new IllegalArgumentException("Invalid booking ID"));
//
//        mockMvc.perform(post("/payments/initiate")
//                        .param("bookingId", "1")
//                        .param("amount", "1000.0")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())  // Updated to 400 BAD REQUEST
//                .andExpect(content().string("Failed to initiate payment: Invalid booking ID"));
//
//        verify(paymentService, times(1)).initiatePayment(1L, 1000.0);
//    }
//
//    @Test
//    void testConfirmPayment_Success() throws Exception {
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentId(1L);
//
//        doReturn(paymentDTO).when(paymentService).confirmPayment(1L);
//
//        mockMvc.perform(post("/payments/confirm")
//                        .param("paymentId", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // Updated to 200 OK
//                .andExpect(content().string("Payment confirmed successfully"));
//
//        verify(paymentService, times(1)).confirmPayment(1L);
//    }
//
//    @Test
//    void testConfirmPayment_Failure() throws Exception {
//        doThrow(new IllegalArgumentException("Invalid payment ID")).when(paymentService).confirmPayment(1L);
//
//        mockMvc.perform(post("/payments/confirm")
//                        .param("paymentId", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())  // Updated to 400 BAD REQUEST
//                .andExpect(content().string("Failed to confirm payment: Invalid payment ID"));
//
//        verify(paymentService, times(1)).confirmPayment(1L);
//    }
//
//    @Test
//    void testPaymentExceptionHandler_Success() throws Exception {
//        when(paymentService.initiatePayment(1L, 1000.0)).thenThrow(new PaymentException("Payment initiation failed"));
//
//        mockMvc.perform(post("/payments/initiate")
//                        .param("bookingId", "1")
//                        .param("amount", "1000.0")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())  // Updated to 400 BAD REQUEST
//                .andExpect(content().string("Payment initiation failed"));
//
//        verify(paymentService, times(1)).initiatePayment(1L, 1000.0);
//    }
//
//    @Test
//    void testPaymentExceptionHandler_Failure() throws Exception {
//        doThrow(new PaymentException("Payment confirmation failed")).when(paymentService).confirmPayment(1L);
//
//        mockMvc.perform(post("/payments/confirm")
//                        .param("paymentId", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())  // Updated to 400 BAD REQUEST
//                .andExpect(content().string("Payment confirmation failed"));
//
//        verify(paymentService, times(1)).confirmPayment(1L);
//    }
//}
