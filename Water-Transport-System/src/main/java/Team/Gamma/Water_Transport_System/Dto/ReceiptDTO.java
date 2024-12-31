package Team.Gamma.Water_Transport_System.Dto;

import Team.Gamma.Water_Transport_System.Entity.Receipt;

import java.util.Date;

public class ReceiptDTO {
    private Long receiptId;
    private Long paymentID;
    private Long userID;
    private Long shipID;
    private TransactionType transactionType;
    public enum TransactionType {
        UPI, CREDIT_DEBIT_CARD, PAYPAL, NETBANKING
    }
    private Double amount;
    private Date date;

    // Getters and Setters
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Long paymentID) {
        this.paymentID = paymentID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getShipID() {
        return shipID;
    }

    public void setShipID(Long shipID) {
        this.shipID = shipID;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

//    public void setTransactionType(Receipt.TransactionType transactionType) {
//        this.transactionType = transactionType;
//    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
