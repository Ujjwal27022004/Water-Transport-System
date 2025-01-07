package Team.Gamma.Water_Transport_System;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.impl.ShipServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipServiceImplTest {

    @Mock
    private ShipDetailsRepository shipDetailsRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private ShipServiceImpl shipService;

    private ShipDetail ship;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ship = new ShipDetail(1L, "Titanic", "New York", "London", 1000, CruiseType.LUXURY, null, 4.5f, true);
    }

    @Test
    void testGetShip() {
        when(shipDetailsRepository.findById(1L)).thenReturn(Optional.of(ship));
        ShipDetail result = shipService.getShip(1L);
        assertNotNull(result);
        assertEquals("Titanic", result.getName());
        verify(shipDetailsRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllShips() {
        when(shipDetailsRepository.findAll()).thenReturn(Arrays.asList(ship));
        List<ShipDetail> result = shipService.getAllShips();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(shipDetailsRepository, times(1)).findAll();
    }

    @Test
    void testSearchCruise() {
        when(shipDetailsRepository.searchCruise("New York", "London")).thenReturn(Arrays.asList(ship));
        List<ShipDetail> result = shipService.searchCruise("New York", "London");
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(shipDetailsRepository, times(1)).searchCruise("New York", "London");
    }

    @Test
    void testGetRemainingSeats() {
        when(shipDetailsRepository.findById(1L)).thenReturn(Optional.of(ship));
        when(bookingRepository.countBookedSeatsForShip(1L)).thenReturn(80);
        int remainingSeats = shipService.getRemainingSeats(1L);
        assertEquals(120, remainingSeats);
        verify(shipDetailsRepository, times(1)).findById(1L);
        verify(bookingRepository, times(1)).countBookedSeatsForShip(1L);
    }

    @Test
    void testGetRemainingSeats_ShipNotFound() {
        when(shipDetailsRepository.findById(1L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> {
            shipService.getRemainingSeats(1L);
        });
         assertEquals("Ship not found with ID: 1", exception.getMessage());
        verify(shipDetailsRepository, times(1)).findById(1L);
    }
}
