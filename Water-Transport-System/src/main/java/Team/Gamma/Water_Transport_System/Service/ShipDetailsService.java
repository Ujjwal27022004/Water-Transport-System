package Team.Gamma.Water_Transport_System.Service;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import java.util.List;

public interface ShipDetailsService {

    public String addShip(ShipDetail ship);
    public String editShip(ShipDetail ship);
    public String deleteShip(Long shipId);
    public ShipDetail getShip(Long adminId);
    public List<ShipDetail> getAllShips();

}
