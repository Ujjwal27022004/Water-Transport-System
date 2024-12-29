package Team.Gamma.Water_Transport_System.Service;


import Team.Gamma.Water_Transport_System.Entity.Bookings;

public interface Bookingservice {

    public String makebooking(Bookings bookings);
    public String cancelbooking(long bookingId);


}
