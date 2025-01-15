package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> createBookingDetails(@RequestBody BookingDTO bookings) {


        if (bookings.getUserid() == null || bookings.getShipId() == null) {
            return ResponseEntity.badRequest().body("User ID and Ship ID cannot be null");
        }
        Bookings newBooking = bookingservice.makeBooking(bookings);
        return ResponseEntity.ok(newBooking.getBookingId().toString());
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

    @GetMapping("/getBookings")
    public ResponseEntity<List<Bookings>> getBookingsByUserId(@RequestParam("userid") Long userid) {
        List<Bookings> bookings = bookingservice.getBookingsByUserid(userid);
        return ResponseEntity.ok(bookings);
    }
}
