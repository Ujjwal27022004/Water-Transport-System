package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
import Team.Gamma.Water_Transport_System.Entity.Payment;

public interface PaymentService {
    public Payment initiatePayment(Long bookingId, double amount);
    public PaymentDTO confirmPayment(Long paymentId);
}
