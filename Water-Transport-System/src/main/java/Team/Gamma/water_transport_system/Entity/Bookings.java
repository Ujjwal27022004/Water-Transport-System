package Team.Gamma.water_transport_system.Entity;


import Team.Gamma.water_transport_system.Enum.BookingStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings_info")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDateTime localDate;
    private int seatsBooked;
    private int totalPrice;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ship_id", nullable = false)
    private ShipDetail ship;

    //Getter and setter
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public LocalDateTime getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getSeatsBooked() {
        return seatsBooked;
    }
    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ShipDetail getShip() {
        return ship;
    }
    public void setShip(ShipDetail ship) {
        this.ship = ship;
    }
    public Thread getPayment() {
        return null;
    }
}


