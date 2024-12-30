package Team.Gamma.Water_Transport_System.Service;

import Team.Gamma.Water_Transport_System.Dto.paymentDTO;
import Team.Gamma.Water_Transport_System.Entity.Payment;

public interface PaymentService {
    public Payment initiatePayment(Long bookingId, double amount);
    public paymentDTO confirmPayment(Long paymentId);
}
