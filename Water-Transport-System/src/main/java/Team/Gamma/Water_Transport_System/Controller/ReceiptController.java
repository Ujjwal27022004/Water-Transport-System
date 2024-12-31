package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.Receipt;
import Team.Gamma.Water_Transport_System.Service.impl.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptServiceImpl receiptService;

    // Endpoint to generate a receipt
    @GetMapping("/generate/{userId}")
    public Receipt generateReceipt(@PathVariable Long userId) {
        return receiptService.generateReceipt(userId);
    }
}
