package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Exception.PaymentException;
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
