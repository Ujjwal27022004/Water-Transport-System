package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
import Team.Gamma.Water_Transport_System.Exception.ReceiptException;
import Team.Gamma.Water_Transport_System.Service.impl.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/receipts")
public class ReceiptController {


    private final ReceiptServiceImpl receiptService;
    @Autowired
    public ReceiptController(ReceiptServiceImpl receiptService) {
        this.receiptService = receiptService;
    }



    // Endpoint to generate a receipt
    @CrossOrigin(origins = "http://localhost:5173")

    @PostMapping("/generate")
    public ResponseEntity<ReceiptDTO> generateReceipt(@RequestParam Long bookingId) {
        ReceiptDTO receiptDTO = receiptService.generateReceipt(bookingId);
        return ResponseEntity.ok(receiptDTO);
    }

    // Exception handler for ReceiptException
    @ExceptionHandler(ReceiptException.class)
    public ResponseEntity<String> handleReceiptException(ReceiptException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
