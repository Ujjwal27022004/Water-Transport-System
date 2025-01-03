package Team.Gamma.Water_Transport_System.Service;
import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import java.util.List;

public interface ShipDetailsService {


    public ShipDetail getShip(Long adminId);
    public List<ShipDetail> getAllShips();
    List<ShipDetail> searchCruise(String source, String destination);
    public int getRemainingSeats(Long shipId);

}
