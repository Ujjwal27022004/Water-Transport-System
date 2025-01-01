package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.Ship;
import Team.Gamma.Water_Transport_System.Exception.ShipDetailNotFoundException;
import Team.Gamma.Water_Transport_System.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipdetails")
public class ShipController {
    private ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/{shipId}")
    public ResponseEntity<Ship> getShipDetails(@PathVariable("shipId") Long shipId) {
        Ship shipDetail = shipService.getShip(shipId);
        if (shipDetail == null) {
            throw new ShipDetailNotFoundException("Ship not found with ID: " + shipId);
        }
        return ResponseEntity.ok(shipDetail);
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getAllShipDetails() {
        List<Ship> ships = shipService.getAllShips();
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ship details found");
        }
        return ResponseEntity.ok(ships);
    }

    @PostMapping
    public String addShipDetails(@RequestBody Ship ship) {
        shipService.addShip(ship);
        return "Ship was successfully created";
    }

    @PutMapping
    public String editShipDetails(@RequestBody Ship ship) {
        shipService.editShip(ship);
        return "Ship was successfully updated";
    }

    @DeleteMapping("{shipId}")
    public String deleteShipDetails(@PathVariable("shipId") Long shipId) {
        shipService.deleteShip(shipId);
        return "Ship Deleted Successfully";
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ship>> getShipDetailsBySourceAndDestination(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination) {
        List<Ship> ships = shipService.searchCruise(source, destination);
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ships found for the given source and destination");
        }
        return ResponseEntity.ok(ships);
    }
}