package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;
import Team.Gamma.Water_Transport_System.Service.PassengerDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class PassengerDetailsControllerTest {

    @Mock
    private PassengerDetailsService passengerDetailsService;

    @InjectMocks
    private PassengerDetailsController passengerDetailsController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(passengerDetailsController).build();
    }

    @Test
    void createPassengerDetails() throws Exception {
        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setPassengerID(2L);
        passengerDetails.setName("Jane Doe");
        passengerDetails.setAge(25);
        passengerDetails.setGender("Female");

        when(passengerDetailsService.createpassengerdetails(any(PassengerDetails.class))).thenReturn("Passenger has been created successfully.");

        mockMvc.perform(post("/passengerDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"passengerId\":2, \"name\":\"Jane Doe\", \"age\":25, \"gender\":\"Female\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Passenger has been created successfully."));
    }

    @Test
    void updatePassengerDetails() throws Exception {
        PassengerDetails passengerDetails = new PassengerDetails();
        passengerDetails.setPassengerID(3L);
        passengerDetails.setName("Tom Smith");
        passengerDetails.setAge(40);
        passengerDetails.setGender("Male");

        when(passengerDetailsService.updatepassengerdetails(any(PassengerDetails.class))).thenReturn(true);

        mockMvc.perform(put("/passengerDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"passengerId\":3, \"name\":\"Tom Smith\", \"age\":40, \"gender\":\"Male\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("The passenger has been updated successfully."));
    }

    @Test
    void deletePassengerDetails() throws Exception {
        when(passengerDetailsService.deletepassengerdetails(4L)).thenReturn(true);

        mockMvc.perform(delete("/passengerDetails/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("Passenger details have been deleted successfully."));
    }
}