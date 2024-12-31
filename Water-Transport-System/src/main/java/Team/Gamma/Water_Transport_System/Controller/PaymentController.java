package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(@RequestParam Long bookingId, @RequestParam double amount) {
        System.out.print("input taken");
        Payment payment = paymentService.initiatePayment(bookingId, amount);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(@RequestParam Long paymentId) {
        paymentService.confirmPayment(paymentId);
        return ResponseEntity.ok("Payment confirmed successfully");
    }
}
