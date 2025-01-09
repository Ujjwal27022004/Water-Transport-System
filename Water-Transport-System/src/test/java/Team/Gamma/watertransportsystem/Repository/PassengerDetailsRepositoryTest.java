package Team.Gamma.watertransportsystem.Repository;

import Team.Gamma.watertransportsystem.Entity.PassengerDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PassengerDetailsRepositoryTest {

    @Autowired
    private PassengerDetailsRepository passengerDetailsRepository;

    private PassengerDetails passengerDetails;

    @BeforeEach
    public void setUp() {
        passengerDetails = new PassengerDetails();
        passengerDetails.setPassengerID(1L);
        passengerDetails.setName("John Doe");
        passengerDetails.setAge(30);
        passengerDetails.setGender("Male");
        passengerDetails.setBookingID(1001L);
    }

    @Test
    public void testSavePassengerDetails() {
        PassengerDetails savedPassenger = passengerDetailsRepository.save(passengerDetails);
        assertNotNull(savedPassenger, "Passenger should be saved");
        assertEquals(passengerDetails.getName(), savedPassenger.getName(), "Name should match");
    }

//    @Test
//    public void testFindById() {
//        passengerDetailsRepository.save(passengerDetails);
//        PassengerDetails foundPassenger = passengerDetailsRepository.findById(passengerDetails.getPassengerId()).orElse(null);
//        assertNotNull(foundPassenger, "Passenger should be found");
//        assertEquals(passengerDetails.getPassengerId(), foundPassenger.getPassengerId(), "Passenger ID should match");
//    }
//
//    @Test
//    public void testCountByBookingId() {
//        // Save the passenger first
//        passengerDetailsRepository.save(passengerDetails);
//
//        // Verify that the passenger is saved (you can log the saved entity if necessary)
//        System.out.println("Saved Passenger Booking ID: " + passengerDetails.getBookingId());
//
//        // Check the count based on the booking ID
//        long count = passengerDetailsRepository.countByBookingId(passengerDetails.getBookingId());
//
//        // Assert the count is 1
//        assertEquals(1, count, "There should be 1 passenger with this booking ID");
//    }




    @Test
    public void testDeleteById() {
        passengerDetailsRepository.save(passengerDetails);
        passengerDetailsRepository.deleteById(passengerDetails.getPassengerId());
        assertFalse(passengerDetailsRepository.existsById(passengerDetails.getPassengerId()), "Passenger should be deleted");
    }
}
