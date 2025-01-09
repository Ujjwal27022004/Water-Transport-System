package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Entity.PassengerDetails;
import Team.Gamma.watertransportsystem.Repository.PassengerDetailsRepository;
import Team.Gamma.watertransportsystem.Service.PassengerDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerDetailsimpl implements PassengerDetailsService {

    private final PassengerDetailsRepository passengerDetailsRepository;

    public PassengerDetailsimpl(PassengerDetailsRepository passengerDetailsRepository) {
        this.passengerDetailsRepository = passengerDetailsRepository;
    }

    @Override
    public PassengerDetails getpassengerdetails(Long passengerId) {
        Optional<PassengerDetails> passengerDetails = passengerDetailsRepository.findById(passengerId);
        return passengerDetails.orElse(null);
    }

    @Override
    public String createpassengerdetails(PassengerDetails passengerDetails) {
        passengerDetailsRepository.save(passengerDetails);
        return "The passenger details have been added successfully.";
    }

    @Override
    public boolean updatepassengerdetails(PassengerDetails passengerDetails) {
        if (passengerDetailsRepository.existsById(passengerDetails.getPassengerId())) {
            passengerDetailsRepository.save(passengerDetails);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletepassengerdetails(Long passengerId) {
        if (passengerDetailsRepository.existsById(passengerId)) {
            passengerDetailsRepository.deleteById(passengerId);
            return true;
        }
        return false;
    }

    @Override
    public List<PassengerDetails> getAllPassengerdetails() {
        return passengerDetailsRepository.findAll();
    }
}
