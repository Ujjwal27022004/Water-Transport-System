package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Exception.ShipDetailNotFoundException;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{shipId}")
    public ResponseEntity<ShipDetail> getShipDetails(@PathVariable("shipId") Long shipId) {
        ShipDetail shipDetail = shipService.getShip(shipId);
        if (shipDetail == null) {
            throw new ShipDetailNotFoundException("Ship not found with ID: " + shipId);
        }
        return ResponseEntity.ok(shipDetail);
    }

    @GetMapping
    public ResponseEntity<List<ShipDetail>> getAllShipDetails() {
        List<ShipDetail> ships = shipService.getAllShips();
        if (ships == null || ships.isEmpty()) {
            throw new ShipDetailNotFoundException("No ship details found");
        }
        return ResponseEntity.ok(ships);
    }

    @PostMapping
    public String addShipDetails(@RequestBody ShipDetail ship) {
        shipService.addShip(ship);
        return "Ship was successfully created";
    }

    @PutMapping
    public String editShipDetails(@RequestBody ShipDetail ship) {
        shipService.editShip(ship);
        return "Ship was successfully updated";
    }

    @DeleteMapping("{shipId}")
    public String deleteShipDetails(@PathVariable("shipId") Long shipId) {
        shipService.deleteShip(shipId);
        return "Ship Deleted Successfully";
    }

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
}