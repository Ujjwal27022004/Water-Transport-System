package Team.Gamma.Water_Transport_System.Service;



import Team.Gamma.Water_Transport_System.Entity.PassengerDetails;

import java.util.List;

public interface PassengerDetailsService {


   //get
    public PassengerDetails getpassengerdetails(Long passengerId);
    //post
    public String createpassengerdetails(PassengerDetails passengerDetails);

    //put
    public String updatepassengerdetails(PassengerDetails passengerDetails);
    //delete

    public String deletepassengerdetails(Long passengerId);

    //list

    public List<PassengerDetails> getAllPassengerdetails();




}
