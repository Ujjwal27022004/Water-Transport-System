package Team.Gamma.watertransportsystem.Service.impl;

import Team.Gamma.watertransportsystem.Entity.ShipDetail;
import Team.Gamma.watertransportsystem.Repository.BookingRepository;
import Team.Gamma.watertransportsystem.Repository.ShipDetailsRepository;
import Team.Gamma.watertransportsystem.Service.ShipDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipDetailsService {
    @Autowired
    private ShipDetailsRepository shipRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public ShipServiceImpl(ShipDetailsRepository shipRepository) {
        this.shipRepository = shipRepository;
    }
    // function to add ship in DB

    // function to get ship details using shipId from DB
    @Override
    public ShipDetail getShip(Long shipId) {
        return shipRepository.findById(shipId).get();
    }
    // function to get all ship details from DB
    @Override
    public List<ShipDetail> getAllShips() {
        return shipRepository.findAll();
    }

    //function to search ship details by using source and destination
    @Override
    public List<ShipDetail> searchCruise(String source, String destination) {
        return shipRepository.searchCruise(source, destination);
    }

    @Override
    public int getRemainingSeats(Long shipId) {
        // Fetch the ship details
        Optional<ShipDetail> optionalShip = shipRepository.findById(shipId);
        if (!optionalShip.isPresent()) {
            throw new RuntimeException("Ship not found with ID: " + shipId);
        }

        ShipDetail ship = optionalShip.get();

        // Get the total booked seats for the ship
        int bookedSeats = bookingRepository.countBookedSeatsForShip(shipId);

        // Calculate remaining seats
        return ship.getCapacity() - bookedSeats;
    }

}
