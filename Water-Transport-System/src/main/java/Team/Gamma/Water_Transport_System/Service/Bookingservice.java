package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;

public interface Bookingservice {

    //booking services
    void makeBooking(BookingDTO bookings);
    boolean cancelBooking(Long bookingId);
    Bookings getLatestBookingByUserId(Long userId);
}