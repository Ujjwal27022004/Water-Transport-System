package Team.Gamma.watertransportsystem.Service;

import Team.Gamma.watertransportsystem.Entity.PassengerDetails;

import java.util.List;

public interface PassengerDetailsService {
 PassengerDetails getpassengerdetails(Long passengerId);

 String createpassengerdetails(PassengerDetails passengerDetails);

 boolean updatepassengerdetails(PassengerDetails passengerDetails);

 boolean deletepassengerdetails(Long passengerId);

 List<PassengerDetails> getAllPassengerdetails();
}
