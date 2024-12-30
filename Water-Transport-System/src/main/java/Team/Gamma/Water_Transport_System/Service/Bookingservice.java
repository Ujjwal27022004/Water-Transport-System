package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDto;

public interface Bookingservice {

    public String makebooking(BookingDto bookings);
    public String cancelbooking(long bookingId);
}
