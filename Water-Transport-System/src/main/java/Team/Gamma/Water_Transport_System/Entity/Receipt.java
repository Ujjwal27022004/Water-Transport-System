package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    private long receiptId;
    private long paymentID;
    private long userId;

    private long shipID;
    private enum transactionType{UPI,CreditCard,DebitCard};
    private double amount;
    private Date date;

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public long getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public long getShipID() {
        return shipID;
    }

    public void setShipID(int shipID) {
        this.shipID = shipID;
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

    public Receipt(int receiptId, int paymentID, int userId, int shipID, double amount, Date date) {
        this.receiptId = receiptId;
        this.paymentID = paymentID;
        this.userId = userId;
        this.shipID = shipID;
        this.amount = amount;
        this.date = date;
    }

    public Receipt() {
    }
}
