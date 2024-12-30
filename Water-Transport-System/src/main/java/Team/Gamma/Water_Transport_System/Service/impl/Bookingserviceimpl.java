package Team.Gamma.Water_Transport_System.Service.impl;


import Team.Gamma.Water_Transport_System.Dto.BookingDto;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;  // Add UserRepository import
import Team.Gamma.Water_Transport_System.Service.Bookingservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Bookingserviceimpl implements Bookingservice {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;  // Add UserRepository field
    @Autowired
    private ShipDetailsRepository shipRepository;

    @Autowired
    private ShipServiceImpl shipService;

    @Override
    public String makebooking(BookingDto bookings) {


        // Save user first
        User user = userRepository.findById(bookings.getUserid()).get();
        ShipDetail shipDetail = shipService.getShip(bookings.getShipId());
        Bookings saveBooking = new Bookings();
        saveBooking.setSeatsBooked(bookings.getSeatsBooked());
        System.out.println("booking seats: " + bookings.getSeatsBooked());
        saveBooking.setUser(user);
        saveBooking.setShip(shipDetail);
        saveBooking.setLocalDate(LocalDateTime.now());
        saveBooking.setTotalPrice(bookings.getTotalPrice());

        // Now save the booking
        bookingRepository.save(saveBooking);  // Save the booking to the database

        return "Your Ticket has been booked successfully!!";
    }

    @Override
    public String cancelbooking(long bookingId) {
        bookingRepository.deleteById(bookingId);  // Delete the booking by ID
        return "Your Ticket has been cancelled successfully";
    }
}
