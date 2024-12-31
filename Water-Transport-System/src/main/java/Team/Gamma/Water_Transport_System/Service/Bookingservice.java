package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;

public interface Bookingservice {

    public String makebooking(BookingDTO bookings);
    public String cancelbooking(Long bookingId);
}
