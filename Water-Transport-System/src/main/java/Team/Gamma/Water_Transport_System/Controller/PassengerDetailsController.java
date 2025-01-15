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


    private final PassengerDetailsService passengerDetailsService;
    @Autowired
    public PassengerDetailsController(PassengerDetailsService passengerDetailsService) {
        this.passengerDetailsService = passengerDetailsService;
    }



    //This method is for creating new entry of passenger
    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public String createPassengerDetails(@RequestBody PassengerDetails passengerDetails) {
        passengerDetailsService.createpassengerdetails(passengerDetails);
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
        return "The passenger has been updated successfully.";
    }

    //This method is for deleting entry of passenger


    //This method is for fetcging all passenger details
    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<PassengerDetails> getAllPassengerDetails() {
        List<PassengerDetails> passengers = passengerDetailsService.getAllPassengerdetails();
        if (passengers == null || passengers.isEmpty()) {
            throw new PassengerDetailsNotFoundException("No passenger details found.");
        }
        return passengers;
    }
}
