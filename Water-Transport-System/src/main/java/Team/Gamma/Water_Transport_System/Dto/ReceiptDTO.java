package Team.Gamma.Water_Transport_System.Dto;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import java.util.Date;

public class ReceiptDTO {
    private Long receiptId;
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
