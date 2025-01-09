package Team.Gamma.water_transport_system.Service;
import Team.Gamma.water_transport_system.Entity.ShipDetail;
import java.util.List;

public interface ShipDetailsService {


    public ShipDetail getShip(Long adminId);
    public List<ShipDetail> getAllShips();
    List<ShipDetail> searchCruise(String source, String destination);
    public int getRemainingSeats(Long shipId);

}
