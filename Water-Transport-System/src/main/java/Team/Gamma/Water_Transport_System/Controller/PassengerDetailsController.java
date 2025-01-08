package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;
import Team.Gamma.Water_Transport_System.Exception.PassengerDetailsNotFoundException;
import Team.Gamma.Water_Transport_System.Service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/passengerDetails")
public class PassengerDetailsController {

    @Autowired
    private PassengerDetailsService passengerDetailsService;

    public PassengerDetailsController(PassengerDetailsService passengerDetailsService) {
        this.passengerDetailsService = passengerDetailsService;
    }

    //This function is for fetching passenger details
    @GetMapping("/{PassengerId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public PassengerDetails fetchPassengerDetails(@PathVariable Long PassengerId) {
        PassengerDetails passengerDetails = passengerDetailsService.getpassengerdetails(PassengerId);
        if (passengerDetails == null) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + PassengerId + " not found.");
        }
        System.out.print("call");
        return passengerDetails;
    }

    //This method is for creating new entry of passenger
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public String createPassengerDetails(@RequestBody PassengerDetails passengerDetails) {
        passengerDetailsService.createpassengerdetails(passengerDetails);
        System.out.print("call");
        return "Passenger has been created successfully.";
    }

    //This method is for updating passenger details

    @PutMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public String updatePassengerDetails(@RequestBody PassengerDetails passengerDetails) {
        boolean isUpdated = passengerDetailsService.updatepassengerdetails(passengerDetails);
        if (!isUpdated) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + passengerDetails.getPassengerId() + " not found for update.");
        }
        System.out.print("call");
        return "The passenger has been updated successfully.";
    }

    //This method is for deleting entry of passenger
    @DeleteMapping("/{PassengerId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public String deletePassengerDetails(@PathVariable Long PassengerId) {
        boolean isDeleted = passengerDetailsService.deletepassengerdetails(PassengerId);
        if (!isDeleted) {
            throw new PassengerDetailsNotFoundException("Passenger with ID " + PassengerId + " not found for deletion.");
        }
        System.out.print("call");
        return "Passenger details have been deleted successfully.";
    }

    //This method is for fetcging all passenger details
    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<PassengerDetails> getAllPassengerDetails() {
        List<PassengerDetails> passengers = passengerDetailsService.getAllPassengerdetails();
        if (passengers == null || passengers.isEmpty()) {
            throw new PassengerDetailsNotFoundException("No passenger details found.");
        }
        System.out.print("call");
        return passengers;
    }
}
