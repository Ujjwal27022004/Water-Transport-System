package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;

import java.util.List;

public interface PassengerDetailsService {
 PassengerDetails getpassengerdetails(Long passengerId);

 String createpassengerdetails(PassengerDetails passengerDetails);

 boolean updatepassengerdetails(PassengerDetails passengerDetails);

 boolean deletepassengerdetails(Long passengerId);

 List<PassengerDetails> getAllPassengerdetails();
}
