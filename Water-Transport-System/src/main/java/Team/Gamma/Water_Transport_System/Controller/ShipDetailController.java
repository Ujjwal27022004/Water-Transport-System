package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Exception.ShipDetailNotFoundException;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/shipdetails")
public class ShipDetailController {

    private final ShipDetailsService shipService;
    @Autowired
    public ShipDetailController(ShipDetailsService shipService) {
        this.shipService = shipService;
    }

    //This method is for fetching details of ship
    @CrossOrigin(origins = "http://localhost:5173")
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
    @CrossOrigin(origins = "http://localhost:5173")
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
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<List<ShipDetail>> getShipDetailsBySourceAndDestination(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:5173");  // Your frontend domain
        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        System.out.println("Received request with source: " + source + " and destination: " + destination);
        List<ShipDetail> ships = shipService.searchCruise(source, destination);
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ships found for the given source and destination");
        }
        return ResponseEntity.ok(ships);
    }

    // //This method is for getting remaining seats of ship
    @GetMapping("/remaining-seats/{shipId}")
    @CrossOrigin(origins = "http://localhost:5173")
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