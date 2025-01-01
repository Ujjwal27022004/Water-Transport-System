package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private Bookingservice bookingservice;

    @PostMapping
    public String createBookingDetails(@RequestBody BookingDTO bookings) {
        bookingservice.makeBooking(bookings);
        return "Booking created successfully";
    }

    @DeleteMapping("{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        boolean isCanceled = bookingservice.cancelBooking(bookingId);
        if (!isCanceled) {
            throw new Team.Gamma.Water_Transport_System.Exception.BookingNotFoundException("Booking not found with ID: " + bookingId);
        }
        return "Your booking has been successfully canceled";
    }
}
