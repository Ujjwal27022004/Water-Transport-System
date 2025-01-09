//package Team.Gamma.Water_Transport_System.Controller;
//
//import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
//import Team.Gamma.Water_Transport_System.Service.BookingService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(BookingController.class)
//class BookingControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookingService bookingService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private BookingDTO bookingDTO;
//
//    @BeforeEach
//    void setUp() {
//        bookingDTO = new BookingDTO();
//        bookingDTO.setLocalDate(LocalDateTime.parse("2025-01-10T10:00:00"));
//        bookingDTO.setSeatsBooked(2);
//        bookingDTO.setTotalPrice(500);
//        bookingDTO.setUserid(1L);
//        bookingDTO.setShipId(1L);
//    }
//
//    @Test
////    @WithMockUser(username = "admin", roles = "ADMIN")
//    void testCancelBooking() throws Exception {
//        // Simulate service behavior
//        when(bookingService.cancelBooking(1L)).thenReturn(true);
//
//        // Perform PUT request and assert results
//        mockMvc.perform(put("/bookings/{bookingId}", 1L))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Your booking has been successfully canceled"));
//
//        // Verify service call
//        verify(bookingService, times(1)).cancelBooking(1L);
//    }
//
//    @Test
//    void testCancelBooking_NotFound() throws Exception {
//        // Simulate service behavior
//        when(bookingService.cancelBooking(1L)).thenReturn(false);
//
//        // Perform PUT request and expect exception
//        mockMvc.perform(put("/bookings/{bookingId}", 1L))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").value("Booking not found with ID: 1"));
//    }
//}
