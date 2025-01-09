package Team.Gamma.watertransportsystem.Controller;

import Team.Gamma.watertransportsystem.Exception.RevenueException;
import Team.Gamma.watertransportsystem.Service.impl.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

    private RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    //This method is for admin to see details of revenue of the ship
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
