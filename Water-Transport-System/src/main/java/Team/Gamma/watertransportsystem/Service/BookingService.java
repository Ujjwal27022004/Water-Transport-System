package Team.Gamma.watertransportsystem.Service;

import Team.Gamma.watertransportsystem.Dto.BookingDTO;
import Team.Gamma.watertransportsystem.Entity.Bookings;

public interface BookingService {

    //booking services
    void makeBooking(BookingDTO bookings);
    boolean cancelBooking(Long bookingId);
    Bookings getLatestBookingByUserId(Long userId);
}