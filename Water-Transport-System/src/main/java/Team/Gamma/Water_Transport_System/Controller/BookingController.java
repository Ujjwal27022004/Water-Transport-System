package Team.Gamma.Water_Transport_System.Controller;


import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;


@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private Bookingservice bookingservice;

    @PostMapping
    public String createbookingdetails(@RequestBody Bookings bookings) {
        bookingservice.makebooking(bookings);
        return "Booking created successfully";
    }

    @DeleteMapping("{bookingId}")
    public String cancelbooking(@PathVariable long bookingId) {
        bookingservice.cancelbooking(bookingId);
        return "Your booking has been successfully canceled";
    }
}

