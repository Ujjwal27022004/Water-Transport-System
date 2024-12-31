package Team.Gamma.Water_Transport_System.Controller;


import Team.Gamma.Water_Transport_System.Service.impl.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping("/{shipId}")

    public int revenueGenerator(@PathVariable int shipId){

        return revenueService.calculateTotalprice(shipId);
    }




}
