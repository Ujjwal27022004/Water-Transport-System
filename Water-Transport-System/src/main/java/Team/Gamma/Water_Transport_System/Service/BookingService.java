package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;

import java.util.List;

public interface BookingService {

    //booking services
    Bookings makeBooking(BookingDTO bookings);
    boolean cancelBooking(Long bookingId);
    Bookings getLatestBookingByUserId(Long userId);
    List<Bookings> getBookingsByUserid(Long userid);
    Bookings getBookingById(Long bookingId);
}