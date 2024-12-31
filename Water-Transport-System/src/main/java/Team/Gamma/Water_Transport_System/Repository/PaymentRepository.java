package Team.Gamma.Water_Transport_System.Repository;

import Team.Gamma.Water_Transport_System.Dto.paymentDTO;
import Team.Gamma.Water_Transport_System.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByBookingId(Long bookingId);
}
