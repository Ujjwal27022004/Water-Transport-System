package Team.Gamma.Water_Transport_System.Service;
import Team.Gamma.Water_Transport_System.Entity.Ship;
import java.util.List;

public interface ShipService {

    public String addShip(Ship ship);
    public String editShip(Ship ship);
    public String deleteShip(Long shipId);
    public Ship getShip(Long adminId);
    public List<Ship> getAllShips();
    List<Ship> searchCruise(String source, String destination);
    public int getRemainingSeats(Long shipId);

}
