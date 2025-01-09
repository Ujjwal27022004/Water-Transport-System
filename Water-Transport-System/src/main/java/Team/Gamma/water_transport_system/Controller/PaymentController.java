package Team.Gamma.water_transport_system.Controller;

import Team.Gamma.water_transport_system.Entity.Payment;
import Team.Gamma.water_transport_system.Exception.PaymentException;
import Team.Gamma.water_transport_system.Service.impl.PaymentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    //This method is for initiating a payment of a user
    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(@RequestParam Long bookingId, @RequestParam double amount) {
        try {
            Payment payment = paymentService.initiatePayment(bookingId, amount);
            return ResponseEntity.status(HttpStatus.OK).body(payment);
        } catch (IllegalArgumentException e) {
            throw new PaymentException("Failed to initiate payment: " + e.getMessage());
        }
    }

    //This method is for confirming a payment of a user
    @PostMapping("/confirm")
    public ResponseEntity<String> confirmPayment(@RequestParam Long paymentId) {
        try {
            paymentService.confirmPayment(paymentId);
            return ResponseEntity.ok("Payment confirmed successfully");
        } catch (IllegalArgumentException e) {
            throw new PaymentException("Failed to confirm payment: " + e.getMessage());
        }
    }
    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<String> handlePaymentException(PaymentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
