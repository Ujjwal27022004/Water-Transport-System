package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.Ship;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipRepository;
import Team.Gamma.Water_Transport_System.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ShipServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }
    // function to add ship in DB
    @Override
    public String addShip(Ship ship) {
        shipRepository.save(ship);
        return "Ship Created Successfully!";
    }
    // function to edit ship in DB
    @Override
    public String editShip(Ship ship) {
        shipRepository.save(ship);
        return "Ship Updated Successfully!";
    }
    // function to delete ship in DB
    @Override
    public String deleteShip(Long shipId) {
        shipRepository.deleteById(shipId);
        return "Ship Deleted Successfully!";
    }
    // function to get ship details using shipId from DB
    @Override
    public Ship getShip(Long shipId) {
        return shipRepository.findById(shipId).get();
    }
    // function to get all ship details from DB
    @Override
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    //function to search ship details by using source and destination
    @Override
    public List<Ship> searchCruise(String source, String destination) {
        return shipRepository.searchCruise(source, destination);
    }

    @Override
    public int getRemainingSeats(Long shipId) {
        // Fetch the ship details
        Optional<Ship> optionalShip = shipRepository.findById(shipId);
        if (!optionalShip.isPresent()) {
            throw new RuntimeException("Ship not found with ID: " + shipId);
        }

        Ship ship = optionalShip.get();

        // Get the total booked seats for the ship
        int bookedSeats = bookingRepository.countBookedSeatsForShip(shipId);

        // Calculate remaining seats
        return ship.getCapacity() - bookedSeats;
    }

}
