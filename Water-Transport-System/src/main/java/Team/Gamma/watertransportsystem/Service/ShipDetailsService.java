package Team.Gamma.watertransportsystem.Service;
import Team.Gamma.watertransportsystem.Entity.ShipDetail;
import java.util.List;

public interface ShipDetailsService {


    public ShipDetail getShip(Long adminId);
    public List<ShipDetail> getAllShips();
    List<ShipDetail> searchCruise(String source, String destination);
    public int getRemainingSeats(Long shipId);

}
