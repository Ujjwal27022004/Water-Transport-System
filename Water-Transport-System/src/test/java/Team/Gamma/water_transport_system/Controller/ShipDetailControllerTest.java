package Team.Gamma.water_transport_system.Controller;

import Team.Gamma.water_transport_system.Entity.ShipDetail;
import Team.Gamma.water_transport_system.Enum.CruiseType;
import Team.Gamma.water_transport_system.Exception.ShipDetailNotFoundException;
import Team.Gamma.water_transport_system.Service.ShipDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipDetailControllerTest {

    @Mock
    private ShipDetailsService shipService;

    @InjectMocks
    private ShipDetailController shipController;

    private ShipDetail ship;

    @BeforeEach
    void setUp() {
        ship = new ShipDetail(1L, "Titanic", "New York", "London", 1000, CruiseType.LUXURY, null, 4.5f, true);
    }

    @Test
    void testGetShipDetails() {
        when(shipService.getShip(1L)).thenReturn(ship);
        ResponseEntity<ShipDetail> response = shipController.getShipDetails(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Titanic", response.getBody().getName());
        verify(shipService, times(1)).getShip(1L);
    }

    @Test
    void testGetAllShipDetails() {
        when(shipService.getAllShips()).thenReturn(Arrays.asList(ship));
        ResponseEntity<List<ShipDetail>> response = shipController.getAllShipDetails();
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        verify(shipService, times(1)).getAllShips();
    }

    @Test
    void testGetShipDetails_ShipNotFound() {
        when(shipService.getShip(1L)).thenReturn(null);
        ShipDetailNotFoundException exception = assertThrows(ShipDetailNotFoundException.class, () -> {
            shipController.getShipDetails(1L);
        });
        assertEquals("Ship not found with ID: 1", exception.getMessage());
        verify(shipService, times(1)).getShip(1L);
    }

    @Test
    void testSearchCruise() {
        when(shipService.searchCruise("New York", "London")).thenReturn(Arrays.asList(ship));
        ResponseEntity<List<ShipDetail>> response = shipController.getShipDetailsBySourceAndDestination("New York", "London");
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        verify(shipService, times(1)).searchCruise("New York", "London");
    }

    @Test
    void testGetRemainingSeats() {
        when(shipService.getRemainingSeats(1L)).thenReturn(800);
        ResponseEntity<?> response = shipController.getRemainingSeats(1L);
        assertNotNull(response);
        assertEquals("Remaining seats: 800", response.getBody());
        verify(shipService, times(1)).getRemainingSeats(1L);
}
}
