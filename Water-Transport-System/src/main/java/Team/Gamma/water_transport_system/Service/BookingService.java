package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Dto.BookingDTO;
import Team.Gamma.water_transport_system.Entity.Bookings;

public interface BookingService {

    //booking services
    void makeBooking(BookingDTO bookings);
    boolean cancelBooking(Long bookingId);
    Bookings getLatestBookingByUserId(Long userId);
}