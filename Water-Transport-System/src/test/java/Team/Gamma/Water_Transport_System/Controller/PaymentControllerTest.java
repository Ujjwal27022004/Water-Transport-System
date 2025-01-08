//package Team.Gamma.Water_Transport_System.Controller;
//
//import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
//import Team.Gamma.Water_Transport_System.Entity.Payment;
//import Team.Gamma.Water_Transport_System.Exception.PaymentException;
//import Team.Gamma.Water_Transport_System.Service.impl.PaymentServiceImpl;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(PaymentController.class)
//public class PaymentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PaymentServiceImpl paymentService;
//
////    @Test
////    public void testInitiatePayment_Success() throws Exception {
////        // Mocking a Payment object
////        Payment mockPayment = new Payment();
////        mockPayment.setPaymentID(1L);
////        mockPayment.setAmount(1000.0);
////        mockPayment.setPaymentStatus("INITIATED");
////
////        // Mocking the service method
////        when(paymentService.initiatePayment(1L, 1000.0)).thenReturn(mockPayment);
////
////        // Performing the POST request
////        mockMvc.perform(post("/payments/initiate")
////                        .param("bookingId", "1")
////                        .param("amount", "1000.0")
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.paymentId").value(1))
////                .andExpect(jsonPath("$.amount").value(1000.0))
////                .andExpect(jsonPath("$.status").value("INITIATED"));
////
////        verify(paymentService, times(1)).initiatePayment(1L, 1000.0);
////    }
//
//    @Test
//    public void testInitiatePayment_Failure() throws Exception {
//        // Simulating an exception
//        when(paymentService.initiatePayment(1L, 1000.0)).thenThrow(new IllegalArgumentException("Invalid booking ID"));
//
//        // Performing the POST request
//        mockMvc.perform(post("/payments/initiate")
//                        .param("bookingId", "1")
//                        .param("amount", "1000.0")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("Failed to initiate payment: Invalid booking ID"));
//
//        verify(paymentService, times(1)).initiatePayment(1L, 1000.0);
//    }
//
//    @Test
//    public void testConfirmPayment_Success() throws Exception {
//        // Create a PaymentDTO object to return from the mock
//        PaymentDTO paymentDTO = new PaymentDTO();
//        paymentDTO.setPaymentId(1L); // Set any necessary fields on the paymentDTO
//
//        // Mock the confirmPayment method to return the paymentDTO
//        doReturn(paymentDTO).when(paymentService).confirmPayment(1L);
//
//        // Perform the POST request
//        mockMvc.perform(post("/payments/confirm")
//                        .param("paymentId", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Payment confirmed successfully"));
//
//        // Verify if the method was called once
//        verify(paymentService, times(1)).confirmPayment(1L);
//    }
//
//    @Test
//    public void testConfirmPayment_Failure() throws Exception {
//        // Correct usage of doThrow() for a void method
//        doThrow(new IllegalArgumentException("Invalid payment ID")).when(paymentService).confirmPayment(1L);
//
//        // Perform the POST request
//        mockMvc.perform(post("/payments/confirm")
//                        .param("paymentId", "1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(content().string("Failed to confirm payment: Invalid payment ID"));
//
//        // Verify if the method was called once
//        verify(paymentService, times(1)).confirmPayment(1L);
//    }
//
//}
//
//
