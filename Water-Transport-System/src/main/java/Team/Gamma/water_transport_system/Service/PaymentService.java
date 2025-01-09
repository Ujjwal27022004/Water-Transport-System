package Team.Gamma.water_transport_system.Service;

import Team.Gamma.water_transport_system.Dto.PaymentDTO;
import Team.Gamma.water_transport_system.Entity.Payment;

public interface PaymentService {
    public Payment initiatePayment(Long bookingId, double amount);
    public PaymentDTO confirmPayment(Long paymentId);
}
