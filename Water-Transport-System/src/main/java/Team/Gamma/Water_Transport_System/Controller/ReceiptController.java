package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.Receipt;
import Team.Gamma.Water_Transport_System.Exception.ReceiptException;
import Team.Gamma.Water_Transport_System.Service.impl.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptServiceImpl receiptService;

    // Endpoint to generate a receipt
    @GetMapping("/generate/{userId}")
    public ResponseEntity<Receipt> generateReceipt(@PathVariable Long userId) {
        try {
            Receipt receipt = receiptService.generateReceipt(userId);
            if (receipt == null) {
                throw new ReceiptException("Receipt generation failed for user ID: " + userId);
            }
            return ResponseEntity.status(HttpStatus.OK).body(receipt);
        } catch (ReceiptException e) {
            throw new ReceiptException("Error generating receipt: " + e.getMessage());
        }
    }

    // Exception handler for ReceiptException
    @ExceptionHandler(ReceiptException.class)
    public ResponseEntity<String> handleReceiptException(ReceiptException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
