package Team.Gamma.watertransportsystem.Service;

import Team.Gamma.watertransportsystem.Dto.PaymentDTO;
import Team.Gamma.watertransportsystem.Entity.Payment;

public interface PaymentService {
    public Payment initiatePayment(Long bookingId, double amount);
    public PaymentDTO confirmPayment(Long paymentId);
}
