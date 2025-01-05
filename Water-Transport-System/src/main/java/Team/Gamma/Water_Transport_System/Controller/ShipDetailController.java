package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Exception.ShipDetailNotFoundException;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/shipdetails")
public class ShipDetailController {
    private ShipDetailsService shipService;
    @Autowired
    public ShipDetailController(ShipDetailsService shipService) {
        this.shipService = shipService;
    }

    //This method is for fetching details of ship
    @GetMapping("/{shipId}")
    public  ResponseEntity<ShipDetail> getShipDetails(@PathVariable("shipId") Long shipId) {
        ShipDetail shipDetail = shipService.getShip(shipId);
        if (shipDetail == null) {
            throw new ShipDetailNotFoundException("Ship not found with ID: " + shipId);
        }
        return ResponseEntity.ok(shipDetail);
    }

    //This method is for fetching details of all ship
    @GetMapping
    public ResponseEntity<List<ShipDetail>> getAllShipDetails() {
        List<ShipDetail> ships = shipService.getAllShips();
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ship details found");
        }
        return ResponseEntity.ok(ships);
    }

    //This method is for adding new ship


    // //This method is for searching details of ship
    @GetMapping("/search")
    public ResponseEntity<List<ShipDetail>> getShipDetailsBySourceAndDestination(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination) {
        List<ShipDetail> ships = shipService.searchCruise(source, destination);
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ships found for the given source and destination");
        }
        return ResponseEntity.ok(ships);
    }

    // //This method is for getting remaining seats of ship
    @GetMapping("/{shipId}/remaining-seats")
    public ResponseEntity<?> getRemainingSeats(@PathVariable Long shipId) {
        try {
            int remainingSeats = shipService.getRemainingSeats(shipId);
            // If remaining seats are negative, set it to 0
            if (remainingSeats < 0) {
                remainingSeats = 0;
            }
            return ResponseEntity.ok("Remaining seats: " + remainingSeats);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching remaining seats");
        }
    }
}