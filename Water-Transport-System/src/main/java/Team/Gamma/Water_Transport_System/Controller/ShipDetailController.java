package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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

    // function for fetching details of ship from DB
    @GetMapping("/{shipId}")
    public ShipDetail getShipDetails(@PathVariable("shipId") Long shipId) {
        return shipService.getShip(shipId);
    }


    // function for fetching details of all ships from DB
    @GetMapping
    public List<ShipDetail> getAllShipDetails() {
        return shipService.getAllShips();
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
        this.shipService = null;
        return "Ship Deleted Successfully";
    }
    // function for searching Ship by using source and destination
    @GetMapping("/search")
    public List<ShipDetail> getShipDetailsBySourceAndDestination(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination) {
        return shipService.searchCruise(source, destination);
    }
}
