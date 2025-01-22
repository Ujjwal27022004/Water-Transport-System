package Team.Gamma.Water_Transport_System.Controller;

import Team.Gamma.Water_Transport_System.Dto.ProductRequest;
import Team.Gamma.Water_Transport_System.Dto.StripeResponse;
import Team.Gamma.Water_Transport_System.Service.impl.StripeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/product/v1")
public class ProductCheckoutController {

    private StripeServiceImpl stripeService;

    public ProductCheckoutController(StripeServiceImpl stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<StripeResponse> checkoutProducts(@RequestBody ProductRequest productRequest) {
        StripeResponse stripeResponse = stripeService.checkoutProducts(productRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stripeResponse);
    }
    @PostMapping ("/success")
    public String success() {
        return "Payment Successfull";
    }

}
