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
    public String createbookingdetails(@RequestBody BookingDTO bookings) {
        bookingservice.makebooking(bookings);
        return "Booking created successfully";
    }

    @DeleteMapping("{bookingId}")
    public String cancelbooking(@PathVariable Long bookingId) {
        bookingservice.cancelbooking(bookingId);
        return "Your booking has been successfully canceled";
    }
}

