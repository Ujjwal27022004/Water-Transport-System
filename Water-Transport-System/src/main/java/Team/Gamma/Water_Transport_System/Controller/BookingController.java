package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createBookingDetails(@RequestBody BookingDTO bookings) {
        System.out.print("userid"+bookings.getUserid());
        System.out.print("shipid"+bookings.getShipId());

        if (bookings.getUserid() == null || bookings.getShipId() == null) {
            return ResponseEntity.badRequest().body("User ID and Ship ID cannot be null");
        }
        bookingservice.makeBooking(bookings);
        return ResponseEntity.ok("Booking created successfully");
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
