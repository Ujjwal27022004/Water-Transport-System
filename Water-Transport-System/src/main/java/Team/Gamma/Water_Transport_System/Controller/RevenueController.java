package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Exception.RevenueException;
import Team.Gamma.Water_Transport_System.Service.impl.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping("/{shipId}")
    public ResponseEntity<Integer> revenueGenerator(@PathVariable int shipId) {
        try {
            int revenue = revenueService.calculateTotalprice(shipId);
            if (revenue < 0) {
                throw new RevenueException("Revenue calculation failed for ship ID: " + shipId);
            }
            return ResponseEntity.status(HttpStatus.OK).body(revenue);
        } catch (RevenueException e) {
            throw new RevenueException("Error generating revenue: " + e.getMessage());
        }
    }

    // Exception handler for RevenueException
    @ExceptionHandler(RevenueException.class)
    public ResponseEntity<String> handleRevenueException(RevenueException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
