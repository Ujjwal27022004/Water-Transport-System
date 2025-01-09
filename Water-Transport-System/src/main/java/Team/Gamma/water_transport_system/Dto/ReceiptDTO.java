package Team.Gamma.water_transport_system.Dto;

import Team.Gamma.water_transport_system.Entity.ShipDetail;
import Team.Gamma.water_transport_system.Entity.User;

import java.util.Date;

public class ReceiptDTO {
    private Long receiptId;
//    private TransactionType transactionType;
    private int amount;
    private Date date;
    private User user;
    private ShipDetail ship;

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


    // Getters and Setters
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

//    public Long getPaymentId() {
//        return paymentID;
//    }

//    public void setPaymentId(Long paymentID) {
//        this.paymentID = paymentID;
//    }

//    public Long getUserId() {
//        return userid;
//    }

//    public void setUserId(Long userID) {
//        this.userid = userID;
//    }

//    public Long getShipId() {
//        return shipID;
//    }

//    public void setShipId(Long shipID) {
//        this.shipID = shipID;
//    }
//    public void setTransactionType(TransactionType transactionType) {
//        this.transactionType = transactionType;
//    }


//    public TransactionType getTransactionType() {
//        return transactionType;
//    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
