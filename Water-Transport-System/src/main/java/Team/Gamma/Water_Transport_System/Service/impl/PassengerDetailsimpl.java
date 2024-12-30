package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;
import Team.Gamma.Water_Transport_System.Repository.PassengerDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.PassengerDetailsService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PassengerDetailsimpl implements PassengerDetailsService {

    PassengerDetailsRepository passengerDetailsRepository;

    public PassengerDetailsimpl(PassengerDetailsRepository passengerDetailsRepository) {
        this.passengerDetailsRepository = passengerDetailsRepository;
    }

//for get
    @Override
    public PassengerDetails getpassengerdetails(Long passengerId) {

        return  passengerDetailsRepository.findById(passengerId).get();
    }



    //for post
    @Override
    public String createpassengerdetails(PassengerDetails passengerDetails) {


        passengerDetailsRepository.save(passengerDetails);

        return "The passenger details have been added successfully";
    }

    //for put
    @Override
    public String updatepassengerdetails(PassengerDetails passengerDetails) {

        passengerDetailsRepository.save(passengerDetails);

        return "The passenger details have been added successfully";
    }
//for delete
    @Override
    public String deletepassengerdetails(Long passengerId) {


        passengerDetailsRepository.deleteById(passengerId);
        return "The passenger has been deleted successfully";
    }

    //for fetching the list;

    @Override
    public List<PassengerDetails> getAllPassengerdetails() {

        return passengerDetailsRepository.findAll();
    }
}
