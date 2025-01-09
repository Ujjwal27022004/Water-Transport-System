package Team.Gamma.water_transport_system.Controller;

import Team.Gamma.water_transport_system.Dto.ReceiptDTO;
import Team.Gamma.water_transport_system.Exception.ReceiptException;
import Team.Gamma.water_transport_system.Service.impl.ReceiptServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {


    private ReceiptServiceImpl receiptService;

    public ReceiptController(ReceiptServiceImpl receiptService) {
        this.receiptService = receiptService;
    }



    // Endpoint to generate a receipt
    @PostMapping("/generate")
    public ResponseEntity<ReceiptDTO> generateReceipt(@RequestParam Long userId) {
        ReceiptDTO receiptDTO = receiptService.generateReceipt(userId);
        return ResponseEntity.ok(receiptDTO);
    }

    // Exception handler for ReceiptException
    @ExceptionHandler(ReceiptException.class)
    public ResponseEntity<String> handleReceiptException(ReceiptException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
