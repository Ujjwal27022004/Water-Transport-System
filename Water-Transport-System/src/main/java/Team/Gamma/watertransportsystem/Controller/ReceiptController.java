package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Dto.ReceiptDTO;
import Team.Gamma.watertransportsystem.Exception.ReceiptException;
import Team.Gamma.watertransportsystem.Service.impl.ReceiptServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {


    private final ReceiptServiceImpl receiptService;
    @Autowired
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
