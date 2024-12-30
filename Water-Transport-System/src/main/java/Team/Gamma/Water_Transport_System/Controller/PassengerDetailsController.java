package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;
import Team.Gamma.Water_Transport_System.Service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/passengerDetails")
public class PassengerDetailsController {

    @Autowired
    PassengerDetailsService passengerDetailsService;

    public PassengerDetailsController(@RequestBody PassengerDetailsService passengerDetailsService) {
        this.passengerDetailsService = passengerDetailsService;
    }


    @GetMapping("{PassengerId}")
    public PassengerDetails fetchpassengerdetails(@PathVariable Long PassengerId){

        return passengerDetailsService.getpassengerdetails(PassengerId);
    }

    @PostMapping

    public String createPassengerdetails(@RequestBody PassengerDetails passengerDetails){

        passengerDetailsService.createpassengerdetails(passengerDetails);

        return "Passenger has been created succesfully";
    }


    @PutMapping

    public String updatePassengerdetails(@RequestBody PassengerDetails passengerDetails){

        passengerDetailsService.updatepassengerdetails(passengerDetails);

        return "The passenger has been updated successfully";
    }

    @DeleteMapping

    public String deletePassengerDetails(@PathVariable Long PassengerId){

        passengerDetailsService.deletepassengerdetails(PassengerId);

        return "Passenger Detais have been deleted";
    }
    @GetMapping()
    public List<PassengerDetails> getallpassengerdetails(){


        return passengerDetailsService.getAllPassengerdetails();
    }


}
