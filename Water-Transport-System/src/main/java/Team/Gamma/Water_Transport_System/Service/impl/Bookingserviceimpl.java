package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.BookingDto;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Bookingserviceimpl implements Bookingservice {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShipDetailsRepository shipRepository;

    @Autowired
    private ShipServiceImpl shipService;

    @Override
    public String makebooking(BookingDto bookings) {

        // Fetch the user from the database
        Optional<User> optionalUser = userRepository.findById(bookings.getUserid());
        if (!optionalUser.isPresent()) {
            return "User not found with ID: " + bookings.getUserid();
        }

        // Fetch the ship details
        ShipDetail shipDetail = shipService.getShip(bookings.getShipId());
        if (shipDetail == null) {
            return "Ship not found with ID: " + bookings.getShipId();
        }

        // Check seat availability before booking
        int bookedSeats = bookingRepository.countBookedSeatsForShip(bookings.getShipId());
        int remainingSeats = shipDetail.getCapacity() - bookedSeats;

        if (remainingSeats < bookings.getSeatsBooked()) {
            return "Not enough seats available on the ship. Remaining seats: " + remainingSeats;
        }

        // Create a new booking
        Bookings saveBooking = new Bookings();
        saveBooking.setSeatsBooked(bookings.getSeatsBooked());
        saveBooking.setUser(optionalUser.get()); // Set the user
        saveBooking.setShip(shipDetail);         // Set the ship
        saveBooking.setLocalDate(LocalDateTime.now());
        saveBooking.setTotalPrice(bookings.getTotalPrice());

        // Save the booking to the database
        bookingRepository.save(saveBooking);

        // Recalculate remaining seats after booking
        bookedSeats += bookings.getSeatsBooked();
        remainingSeats = shipDetail.getCapacity() - bookedSeats;

        return "Your Ticket has been booked successfully! Remaining seats: " + remainingSeats;
    }



    @Override
    public String cancelbooking(long bookingId) {
        Optional<Bookings> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            return "Booking not found with ID: " + bookingId;
        }
        // Delete the booking by ID
        bookingRepository.deleteById(bookingId);
        return "Your Ticket has been cancelled successfully!";
    }
}
