package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    private long paymentID;



    private long bookingID;
    private enum paymentStatus{Successful,Pending,Cancelled};

    private String paymentMethod;

    private double amount;
    private Date date;

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
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

    public Payment() {
    }

    public Payment(int paymentID, int bookingID, String paymentMethod, double amount, Date date) {
        this.paymentID = paymentID;
        this.bookingID = bookingID;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
    }

}
