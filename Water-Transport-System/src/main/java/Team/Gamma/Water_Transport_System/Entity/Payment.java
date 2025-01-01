package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long paymentId;
    @Column(name = "bookingId", insertable = false, updatable = false)
    private Long bookingId;
    @Column(name = "paymentStatus")
    private String paymentStatus;
    @Column(name = "amount")
    private double amount;
    @Column(name = "date")
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(name = "paymentMethod")
    private PaymentMethod paymentMethod;

    public enum PaymentMethod {
        UPI, CREDIT_DEBIT_CARD, PAYPAL, NETBANKING
    }

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Bookings booking; // Foreign key to Booking entity

    public Long getPaymentID() {
        return paymentId;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentId = paymentID;
    }

    public Long getBookingID() {
        return bookingId;
    }

    public void setBookingID(Long bookingID) {
        this.bookingId = bookingID;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    //constructor
    public Payment() {
    }

    public Payment(Long paymentID, Long bookingID, PaymentMethod paymentMethod, double amount, Date date) {
        this.paymentId = paymentID;
        this.bookingId = bookingID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
    }

}
