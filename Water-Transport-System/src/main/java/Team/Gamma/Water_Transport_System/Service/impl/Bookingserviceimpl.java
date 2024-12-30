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

        // Create a new booking and set the details
        Bookings saveBooking = new Bookings();
        saveBooking.setSeatsBooked(bookings.getSeatsBooked());
        System.out.println("Booking seats: " + bookings.getSeatsBooked());
        saveBooking.setUser(optionalUser.get()); // Use the user fetched above
        saveBooking.setShip(shipDetail);
        saveBooking.setLocalDate(LocalDateTime.now());
        saveBooking.setTotalPrice(bookings.getTotalPrice());

        // Save the booking to the database
        bookingRepository.save(saveBooking);

        return "Your Ticket has been booked successfully!";
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
