package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;
import Team.Gamma.Water_Transport_System.Exception.PassengerDetailsNotFoundException;
import Team.Gamma.Water_Transport_System.Service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerDetails")
public class PassengerDetailsController {

    @Autowired
    private PassengerDetailsService passengerDetailsService;

    public PassengerDetailsController(PassengerDetailsService passengerDetailsService) {
        this.passengerDetailsService = passengerDetailsService;
    }

    @GetMapping("/{PassengerId}")
    public PassengerDetails fetchPassengerDetails(@PathVariable Long PassengerId) {
        PassengerDetails passengerDetails = passengerDetailsService.getpassengerdetails(PassengerId);
        if (passengerDetails == null) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + PassengerId + " not found.");
        }
        return passengerDetails;
    }

    @PostMapping
    public String createPassengerDetails(@RequestBody PassengerDetails passengerDetails) {
        passengerDetailsService.createpassengerdetails(passengerDetails);
        return "Passenger has been created successfully.";
    }

    @PutMapping
    public String updatePassengerDetails(@RequestBody PassengerDetails passengerDetails) {
        boolean isUpdated = passengerDetailsService.updatepassengerdetails(passengerDetails);
        if (!isUpdated) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + passengerDetails.getPassengerId() + " not found for update.");
        }
        return "The passenger has been updated successfully.";
    }

    @DeleteMapping("/{PassengerId}")
    public String deletePassengerDetails(@PathVariable Long PassengerId) {
        boolean isDeleted = passengerDetailsService.deletepassengerdetails(PassengerId);
        if (!isDeleted) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + PassengerId + " not found for deletion.");
        }
        return "Passenger details have been deleted successfully.";
    }

    @GetMapping
    public List<PassengerDetails> getAllPassengerDetails() {
        List<PassengerDetails> passengers = passengerDetailsService.getAllPassengerdetails();
        if (passengers == null || passengers.isEmpty()) {
            throw new PassengerDetailsNotFoundException("No passenger details found.");
        }
        return passengers;
    }
}
