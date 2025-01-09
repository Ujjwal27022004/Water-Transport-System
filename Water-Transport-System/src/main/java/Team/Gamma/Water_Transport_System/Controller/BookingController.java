package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {


    private final BookingService bookingservice;
    @Autowired
    public BookingController(BookingService bookingservice) {
        this.bookingservice = bookingservice;
    }

    //Create booking for user
    @PostMapping
    public String createBookingDetails(@RequestBody BookingDTO bookings) {
        bookingservice.makeBooking(bookings);
        return "Booking created successfully";
    }

    //cancel booking of user
    @PutMapping("{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        boolean isCanceled = bookingservice.cancelBooking(bookingId);
        if (!isCanceled) {
            throw new Team.Gamma.Water_Transport_System.Exception.BookingNotFoundException("Booking not found with ID: " + bookingId);
        }
        return "Your booking has been successfully canceled";
    }
}
