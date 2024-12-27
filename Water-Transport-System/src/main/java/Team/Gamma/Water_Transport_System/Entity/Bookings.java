package Team.Gamma.Water_Transport_System.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(name = "bookings_info")

public class Bookings {

    @Id
    private long bookingId;
    private int userId;
    private int shipId;
    private Date localdate;
    private int seatsbooked;
    private int totalprice;

    public Bookings() {

    }

    public Bookings(long bookingId, int userId, int shipId, Date localdate, int seatsbooked, int totalprice) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.shipId = shipId;
        this.localdate = localdate;
        this.seatsbooked = seatsbooked;
        this.totalprice = totalprice;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public Date getLocaldate() {
        return localdate;
    }

    public void setLocaldate(Date localdate) {
        this.localdate = localdate;
    }

    public int getSeatsbooked() {
        return seatsbooked;
    }

    public void setSeatsbooked(int seatsbooked) {
        this.seatsbooked = seatsbooked;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}

