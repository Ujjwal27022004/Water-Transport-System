package Team.Gamma.Water_Transport_System.Controller;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/shipdetails")
public class ShipDetailController {
    private final ShipDetailsService shipDetailService;

    public ShipDetailController(ShipDetailsService shipDetailService) {
        this.shipDetailService = shipDetailService;
    }

    @GetMapping("{shipId}")
    public ShipDetail getShipDetails(@PathVariable("shipId") String shipId){
        return shipDetailService.getShipDetails(shipId);
    }

    @GetMapping()
    public List<ShipDetail> getAllShipDetails(){
        return shipDetailService.getAllShipDetails();

//        return new CloudVendor("C1","Vendor 1","Address one","XXXXXX");
    }
    @PostMapping
    public String createShipDetails(@RequestBody ShipDetail shipDetail){
        shipDetailService.createShipDetails(shipDetail);
        return "Ship Created Successfully";
    }
////
//

}

//Template for API Testing
// {
//     "shipId": 2,
//     "name": "shipname 2",
//     "source": "Mumbai",
//     "capacity": 2,
//     "cruiseLength": 8.0,
//     "cruiseType": "Deluxe",
//     "date": "2025-01-01",
//     "price": 4000.0,
//     "rating": 3.8,
//     "availability": true,
//     "destination": "Gujrat"
// }
