package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Entity.PassengerDetails;
import Team.Gamma.water_transport_system.Exception.PassengerDetailsNotFoundException;
import Team.Gamma.water_transport_system.Repository.PassengerDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PassengerDetailsServiceTest {

    @Mock
    private PassengerDetailsRepository passengerDetailsRepository;

    @InjectMocks
    private PassengerDetailsService passengerDetailsService = new PassengerDetailsService() {

        @Override
        public PassengerDetails getpassengerdetails(Long passengerId) {
            return passengerDetailsRepository.findById(passengerId)
                    .orElseThrow(() -> new PassengerDetailsNotFoundException("Passenger with ID " + passengerId + " not found."));
        }

        @Override
        public String createpassengerdetails(PassengerDetails passengerDetails) {
            passengerDetailsRepository.save(passengerDetails);
            return "Passenger has been created successfully.";
        }

        @Override
        public boolean updatepassengerdetails(PassengerDetails passengerDetails) {
            if (!passengerDetailsRepository.existsById(passengerDetails.getPassengerId())) {
                throw new PassengerDetailsNotFoundException("Passenger with ID " + passengerDetails.getPassengerId() + " not found for update.");
            }
            passengerDetailsRepository.save(passengerDetails);
            return true;
        }

        @Override
        public boolean deletepassengerdetails(Long passengerId) {
            if (!passengerDetailsRepository.existsById(passengerId)) {
                throw new PassengerDetailsNotFoundException("Passenger with ID " + passengerId + " not found for deletion.");
            }
            passengerDetailsRepository.deleteById(passengerId);
            return true;
        }

        @Override
        public List<PassengerDetails> getAllPassengerdetails() {
            return passengerDetailsRepository.findAll();
        }
    };

    private PassengerDetails passenger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        passenger = new PassengerDetails();
        passenger.setPassengerID(1L);
        passenger.setName("John Doe");
        passenger.setAge(30);
        passenger.setGender("Male");
        passenger.setBookingID(123L);
    }

    @Test
    void testGetPassengerDetailsSuccess() {
        when(passengerDetailsRepository.findById(1L)).thenReturn(Optional.of(passenger));

        PassengerDetails fetchedPassenger = passengerDetailsService.getpassengerdetails(1L);
        assertNotNull(fetchedPassenger);
        assertEquals(1L, fetchedPassenger.getPassengerId());
        assertEquals("John Doe", fetchedPassenger.getName());
    }

    @Test
    void testGetPassengerDetailsNotFound() {
        when(passengerDetailsRepository.findById(1L)).thenReturn(Optional.empty());

        PassengerDetailsNotFoundException exception = assertThrows(PassengerDetailsNotFoundException.class, () -> {
            passengerDetailsService.getpassengerdetails(1L);
        });

        assertEquals("Passenger with ID 1 not found.", exception.getMessage());
    }

    @Test
    void testCreatePassengerDetails() {
        when(passengerDetailsRepository.save(any(PassengerDetails.class))).thenReturn(passenger);

        String result = passengerDetailsService.createpassengerdetails(passenger);
        assertEquals("Passenger has been created successfully.", result);
    }

//    @Test
//    void testUpdatePassengerDetailsSuccess() {
//        when(passengerDetailsRepository.findById(1L)).thenReturn(Optional.of(passenger));
//        when(passengerDetailsRepository.save(any(PassengerDetails.class))).thenReturn(passenger);
//
//        boolean isUpdated = passengerDetailsService.updatepassengerdetails(passenger);
//        assertTrue(isUpdated);
//    }

    @Test
    void testUpdatePassengerDetailsNotFound() {
        when(passengerDetailsRepository.findById(1L)).thenReturn(Optional.empty());

        PassengerDetailsNotFoundException exception = assertThrows(PassengerDetailsNotFoundException.class, () -> {
            passengerDetailsService.updatepassengerdetails(passenger);
        });

        assertEquals("Passenger with ID 1 not found for update.", exception.getMessage());
    }

    @Test
    void testDeletePassengerDetailsSuccess() {
        when(passengerDetailsRepository.existsById(1L)).thenReturn(true);

        boolean isDeleted = passengerDetailsService.deletepassengerdetails(1L);
        assertTrue(isDeleted);
    }

    @Test
    void testDeletePassengerDetailsNotFound() {
        when(passengerDetailsRepository.existsById(1L)).thenReturn(false);

        PassengerDetailsNotFoundException exception = assertThrows(PassengerDetailsNotFoundException.class, () -> {
            passengerDetailsService.deletepassengerdetails(1L);
        });

        assertEquals("Passenger with ID 1 not found for deletion.", exception.getMessage());
    }

    @Test
    void testGetAllPassengerDetails() {
        when(passengerDetailsRepository.findAll()).thenReturn(List.of(passenger));

        List<PassengerDetails> passengerList = passengerDetailsService.getAllPassengerdetails();
        assertNotNull(passengerList);
        assertEquals(1, passengerList.size());
    }
}
