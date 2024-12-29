package Team.Gamma.Water_Transport_System.Service;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import java.util.List;

public interface ShipDetailsService {

    public ShipDetail getShipDetails(String shipId);
    public List<ShipDetail> getAllShipDetails();
    public String createShipDetails(ShipDetail shipDetail);

}
