package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/shipdetails")
public class ShipDetailController {
    private ShipDetailsService shipService;

    @Autowired
    public ShipDetailController(ShipDetailsService shipService) {
        this.shipService = shipService;
    }

    // function for fetching details of ship from DB
    @GetMapping("/{shipId}")
    public ResponseEntity<?> getShipDetails(@PathVariable("shipId") Long shipId) {
        try {
            ShipDetail shipDetail = shipService.getShip(shipId);
            return ResponseEntity.ok(shipDetail);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ship not found with ID: " + shipId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching ship details");
        }
    }


    // function for fetching details of all ships from DB
    @GetMapping
    public ResponseEntity<?> getAllShipDetails() {
        try {
            List<ShipDetail> ships = shipService.getAllShips();
            if (ships == null || ships.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ship details found");
            }
            return ResponseEntity.ok(ships);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching all ship details");
        }
    }
    // function for creating Ship in DB
    @PostMapping
    public String addShipDetails(@RequestBody ShipDetail ship) {
        shipService.addShip(ship);
        return "Ship was successfully created";
    }
    // function for editing Ship details in DB
    @PutMapping
    public String editShipDetails(@RequestBody ShipDetail ship) {
        shipService.editShip(ship);
        return "Ship was successfully updated";
    }
    // function for deleting Ship from DB
    @DeleteMapping("{shipId}")
    public String deleteShipDetails(@PathVariable("shipId") Long shipId){
        shipService.deleteShip(shipId);
        return "Ship Deleted Successfully";
    }
    // Function for searching Ship by using source and destination
    @GetMapping("/search")
    public ResponseEntity<?> getShipDetailsBySourceAndDestination(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination) {
        try {
            List<ShipDetail> ships = shipService.searchCruise(source, destination);
            if (ships == null || ships.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No ships found for the given source and destination");
            }
            return ResponseEntity.ok(ships);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error searching ships");
        }
    }
}


