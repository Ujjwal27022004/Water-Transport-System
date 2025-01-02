package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Exception.BookingNotFoundException;
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
    private static final int PRICE_PER_SEAT = 1000;

    @Override
    public void makeBooking(BookingDTO bookings) {
        Optional<User> optionalUser = userRepository.findById(bookings.getUserid());
        if (!optionalUser.isPresent()) {
            throw new BookingNotFoundException("User not found with ID: " + bookings.getUserid());
        }

        ShipDetail shipDetail = shipService.getShip(bookings.getShipId());
        if (shipDetail == null) {
            throw new BookingNotFoundException("User not found with ID: " + bookings.getUserid());
        }

        int totalPrice = bookings.getSeatsBooked() * PRICE_PER_SEAT;
        bookings.setTotalPrice(totalPrice);

        int bookedSeats = bookingRepository.countBookedSeatsForShip(bookings.getShipId());
        int remainingSeats = shipDetail.getCapacity() - bookedSeats;

        if (remainingSeats < bookings.getSeatsBooked()) {
            throw new IllegalArgumentException("Not enough seats available. Remaining seats: " + remainingSeats);
        }

        Bookings saveBooking = new Bookings();
        saveBooking.setSeatsBooked(bookings.getSeatsBooked());
        saveBooking.setUser(optionalUser.get());
        saveBooking.setShip(shipDetail);
        saveBooking.setLocalDate(bookings.getLocalDate() != null ? bookings.getLocalDate() : LocalDateTime.now());
        saveBooking.setTotalPrice(totalPrice);

        bookingRepository.save(saveBooking);
    }

    @Override
    public boolean cancelBooking(Long bookingId) {
        Optional<Bookings> optionalBooking = bookingRepository.findById(bookingId);
        if (!optionalBooking.isPresent()) {
            return false; // Booking not found
        }

        bookingRepository.deleteById(bookingId);
        return true; // Booking canceled successfully
    }

    public Bookings getLatestBookingByUserId(Long userId) {
        return bookingRepository.findByUser_userid(userId);
    }
}
