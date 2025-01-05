package Team.Gamma.Water_Transport_System.Dto;

import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Enum.PaymentMethod;

import java.util.Date;

public class PaymentDTO {
    private Long paymentId;
    private Long bookingId;
    private String message;
    private boolean success;
    private String paymentStatus;
    private double amount;
    private Date date;
    private PaymentMethod paymentMethod;



    //Getter and Setter

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public PaymentDTO() {
    }
    public PaymentDTO(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}

