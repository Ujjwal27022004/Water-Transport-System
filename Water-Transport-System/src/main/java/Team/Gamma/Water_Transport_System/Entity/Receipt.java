package Team.Gamma.Water_Transport_System.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiptId")
    private Long receiptId;
    @Column(name = "paymentId",insertable = false, updatable = false)
    private Long paymentId;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;

    public Long getUserid() {
        return userId;
    }



    public void setUserid(Long userid) {
        this.userId = userid;
    }

    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;
    @Column(name = "shipId", insertable = false, updatable = false)
    private Long shipId;

    @Column(name = "date")
    private Date date;

    public User getUser() {
        return user;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    @JsonManagedReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shipId")
    @JsonManagedReference

    private ShipDetail ship;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "paymentId")
    @JsonManagedReference

    private Payment payment;

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public long getPaymentID() {
        return paymentId;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentId = paymentID;
    }

    public long getShipID() {
        return shipId;
    }

    public void setShipID(Long shipID) {
        this.shipId = shipID;
    }


    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Receipt(Long receiptId, Long paymentId, int amount, Long userId, Long shipId, Date date, User user, ShipDetail ship, Payment payment) {
        this.receiptId = receiptId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.userId = userId;
        this.shipId = shipId;
        this.date = date;
        this.user = user;
        this.ship = ship;
        this.payment = payment;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setShip(ShipDetail ship) {
        this.ship = ship;
    }




    public Receipt() {
    }
}
