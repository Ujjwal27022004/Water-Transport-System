//package Team.Gamma.Water_Transport_System.Controller;
//
//import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
//import Team.Gamma.Water_Transport_System.Exception.ReceiptException;
//import Team.Gamma.Water_Transport_System.Service.impl.ReceiptServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(ReceiptController.class) // Load only ReceiptController and related components
//public class ReceiptControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean // Mock ReceiptServiceImpl
//    private ReceiptServiceImpl receiptService;
//
//    @BeforeEach
//    void setUp() {
//        // Mock security context
//        SecurityContext securityContext = mock(SecurityContext.class);
//        Authentication authentication = mock(Authentication.class);
//
//        when(securityContext.getAuthentication()).thenReturn(authentication);
//        when(authentication.getName()).thenReturn("testUser");
//
//        SecurityContextHolder.setContext(securityContext);
//    }
//
////    @Test
////    public void testGenerateReceipt_Success() throws Exception {
////        // Mocking the ReceiptDTO response
////        ReceiptDTO mockReceiptDTO = new ReceiptDTO();
////        mockReceiptDTO.setAmount(1000);
////        mockReceiptDTO.setReceiptId(1L);
////
////        // Mock service behavior
////        when(receiptService.generateReceipt(1L)).thenReturn(mockReceiptDTO);
////
////        // Perform POST request and validate response
////        mockMvc.perform(post("/receipts/generate")
////                        .param("userId", "1") // Pass userId as request parameter
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk()) // Expect HTTP 200 OK
////                .andExpect(jsonPath("$.amount").value(1000)) // Validate receipt amount
////                .andExpect(jsonPath("$.receiptId").value(1)); // Validate receipt ID
////    }
//
////    @Test
////    public void testGenerateReceipt_ReceiptException() throws Exception {
////        // Simulate an exception in the service
////        when(receiptService.generateReceipt(2L)).thenThrow(new ReceiptException("User not found"));
////
////        // Perform POST request and validate exception handling
////        mockMvc.perform(post("/receipts/generate")
////                        .param("userId", "2") // Pass userId that triggers exception
////                        .contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isForbidden()) // Expect HTTP 400 Bad Request
////                .andExpect(content().string("")); // Validate exception message
////    }
////}
//
//@Configuration
//class SecurityTestConfig {
//    @Bean
//    public SecurityFilterChain filterChain(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
//        http.csrf().disable() // Disable CSRF for testing purposes
//                .authorizeRequests().anyRequest().permitAll(); // Allow all requests
//        return http.build();
//    }
//}}
