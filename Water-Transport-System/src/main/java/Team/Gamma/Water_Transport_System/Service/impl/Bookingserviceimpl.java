package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.BookingDTO;
import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import Team.Gamma.Water_Transport_System.Exception.BookingNotFoundException;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.UserRepository;
import Team.Gamma.Water_Transport_System.Service.BookingService;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class Bookingserviceimpl implements BookingService {
private static final Map<CruiseType, Function<Integer, Integer>> PRICING_STRATEGY = Map.of(
        CruiseType.FAMILY, seats -> seats * 800,
        CruiseType.DELUXE, seats -> seats * 1200,
        CruiseType.LUXURY, seats -> seats * 2000,
        CruiseType.PREMIUM, seats -> seats * 1500
);

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ShipDetailsService shipService;

    @Autowired
    public Bookingserviceimpl(BookingRepository bookingRepository, UserRepository userRepository, ShipDetailsService shipService) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.shipService = shipService;
    }

    @Override
    public Bookings makeBooking(BookingDTO bookingDTO) {
        User user = userRepository.findById(bookingDTO.getUserid())
                .orElseThrow(() -> new BookingNotFoundException("User not found with ID: " + bookingDTO.getUserid()));

        ShipDetail shipDetail = shipService.getShip(bookingDTO.getShipId());
        if (shipDetail == null) {
            throw new BookingNotFoundException("Ship not found with ID: " + bookingDTO.getShipId());
        }

        CruiseType cruiseType = shipDetail.getCruiseType(); // Assuming ShipDetail has a `getCruiseType()` method
        if (!PRICING_STRATEGY.containsKey(cruiseType)) {
            throw new IllegalArgumentException("Pricing strategy not defined for cruise type: " + cruiseType);
        }

        int bookedSeats = bookingRepository.countBookedSeatsForShip(bookingDTO.getShipId());
        int remainingSeats = shipDetail.getCapacity() - bookedSeats;

        if (remainingSeats < bookingDTO.getSeatsBooked()) {
            throw new IllegalArgumentException("Not enough seats available. Remaining seats: " + remainingSeats);
        }

        // Calculate price using the lambda from the pricing strategy map
        int totalPrice = PRICING_STRATEGY.get(cruiseType).apply(bookingDTO.getSeatsBooked());

        Bookings newBooking = new Bookings();
        newBooking.setSeatsBooked(bookingDTO.getSeatsBooked());
        newBooking.setUser(user);
        newBooking.setShip(shipDetail);
        newBooking.setBookingStatus(BookingStatus.PENDING);
        newBooking.setLocalDate(bookingDTO.getLocalDate() != null ? bookingDTO.getLocalDate() : LocalDateTime.now());
        newBooking.setTotalPrice(totalPrice);

        return bookingRepository.save(newBooking);
    }


    @Override
    public boolean cancelBooking(Long bookingId) {
        Bookings booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found with ID: " + bookingId));

        booking.setBookingStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);

        return true;
    }

    @Override
    public Bookings getLatestBookingByUserId(Long userId) {
        return Optional.ofNullable(bookingRepository.findByUser_userid(userId))
                .orElseThrow(() -> new BookingNotFoundException("No bookings found for user ID: " + userId));
    }
    @Override
    public Bookings getBookingById(Long bookingId) {
        return Optional.ofNullable(bookingRepository.findByBookingId(bookingId))
                .orElseThrow(() -> new BookingNotFoundException("No bookings found for with ID: " + bookingId));
    }


    @Override
    public List<Bookings> getBookingsByUserid(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BookingNotFoundException("User not found with ID: " + userId));

        List<Bookings> bookings = bookingRepository.findByUser(user);
        if (bookings.isEmpty()) {
            throw new BookingNotFoundException("No bookings found for user ID: " + userId);
        }

        return bookings;
    }
}
