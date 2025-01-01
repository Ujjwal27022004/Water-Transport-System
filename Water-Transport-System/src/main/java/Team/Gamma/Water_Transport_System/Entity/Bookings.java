package Team.Gamma.Water_Transport_System.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bookings_info")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private LocalDateTime localDate;
    private int seatsBooked;
    private int totalPrice;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
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


