package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "Receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receiptId")
    private Long receiptId;
    @Column(name = "paymentId", insertable = false, updatable = false)
    private Long paymentId;
    @Column(name = "userId", insertable = false, updatable = false)
    private Long userId;
    @Column(name = "shipId", insertable = false, updatable = false)
    private Long shipId;
    @Enumerated(EnumType.STRING)
    @Column(name = "transactionType")
    private Payment.PaymentMethod transactionType;
    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private double amount;


    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "shipId", nullable = false)
    private ShipDetail ship;

    @ManyToOne
    @JoinColumn(name = "paymentId", nullable = false)
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

    public long getUserID() {
        return userId;
    }

    public void setUserID(Long userID) {
        this.userId = userID;
    }

    public long getShipID() {
        return shipId;
    }

    public void setShipID(Long shipID) {
        this.shipId = shipID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
    public Payment.PaymentMethod getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Payment.PaymentMethod transactionType) {
        this.transactionType = transactionType;
    }


    public Receipt(Long receiptId, Long paymentID, Long userID, Long shipID, double amount, Date date) {
        this.receiptId = receiptId;
        this.paymentId = paymentID;
        this.userId = userID;
        this.shipId = shipID;
        this.amount = amount;
        this.date = date;
    }

    public Receipt() {
    }
}
