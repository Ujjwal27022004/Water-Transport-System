package Team.Gamma.Water_Transport_System.Impl;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.ShipDetailsService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipDetailsServiceImpl implements ShipDetailsService {
    ShipDetailsRepository shipDetailsRepository;

    public ShipDetailsServiceImpl(ShipDetailsRepository shipDetailsRepository) {
        this.shipDetailsRepository = shipDetailsRepository;
    }

    @Override
    public ShipDetail getShipDetails(String shipId) {
        return shipDetailsRepository.findById(Long.parseLong(shipId))
                .orElseThrow(() -> new RuntimeException("Ship not found"));
    }

    @Override
    public List<ShipDetail> getAllShipDetails() {
        return shipDetailsRepository.findAll();
    }

    @Override
    public String createShipDetails(ShipDetail shipDetail) {
        shipDetailsRepository.save(shipDetail);
        return "Success";
    }


}
