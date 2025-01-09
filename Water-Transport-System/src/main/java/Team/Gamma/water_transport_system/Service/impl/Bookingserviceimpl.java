package Team.Gamma.water_transport_system.Service.impl;

import Team.Gamma.water_transport_system.Dto.BookingDTO;
import Team.Gamma.water_transport_system.Entity.Bookings;
import Team.Gamma.water_transport_system.Entity.ShipDetail;
import Team.Gamma.water_transport_system.Entity.User;
import Team.Gamma.water_transport_system.Enum.BookingStatus;
import Team.Gamma.water_transport_system.Exception.BookingNotFoundException;
import Team.Gamma.water_transport_system.Repository.BookingRepository;
import Team.Gamma.water_transport_system.Repository.ShipDetailsRepository;
import Team.Gamma.water_transport_system.Repository.UserRepository;
import Team.Gamma.water_transport_system.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class Bookingserviceimpl implements BookingService {

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
        saveBooking.setBookingStatus(BookingStatus.PENDING);
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
        Bookings bookings = optionalBooking.get();
        bookings.setBookingStatus(BookingStatus.CANCELLED);
        bookingRepository.save(bookings);
//        bookingRepository.deleteById(bookingId);

        return true; // Booking canceled successfully
    }
    @Override
    public Bookings getLatestBookingByUserId(Long userId) {
        return bookingRepository.findByUser_userid(userId);
    }
}
