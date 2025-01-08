package Team.Gamma.Water_Transport_System.Entity;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShipDetailTest {

    private ShipDetail shipDetail;

    @BeforeEach
    void setUp() {
        shipDetail = new ShipDetail(
                1L, "Ship A", "Port A", "Port B",
                500, CruiseType.LUXURY, new Date(), 4.5f, true
        );
    }

    @Test
    void testShipDetailConstructor() {
        assertNotNull(shipDetail, "ShipDetail object should not be null");
        assertEquals(1L, shipDetail.getShipId(), "Ship ID should be 1");
        assertEquals("Ship A", shipDetail.getName(), "Ship name should be Ship A");
        assertEquals("Port A", shipDetail.getSource(), "Source should be Port A");
        assertEquals("Port B", shipDetail.getDestination(), "Destination should be Port B");
        assertEquals(500, shipDetail.getCruiseLength(), "Cruise length should be 500");
        assertEquals(CruiseType.LUXURY, shipDetail.getCruiseType(), "Cruise type should be LUXURY");
        assertNotNull(shipDetail.getDate(), "Date should not be null");
        assertEquals(4.5f, shipDetail.getRating(), "Rating should be 4.5");
        assertTrue(shipDetail.getAvailability(), "Availability should be true");
    }

    @Test
    void testSettersAndGetters() {
        shipDetail.setShipId(2L);
        shipDetail.setName("Ship B");
        shipDetail.setSource("Port C");
        shipDetail.setDestination("Port D");
        shipDetail.setDate(new Date());
        shipDetail.setCruiseLength(600);
        shipDetail.setRating(4.8f);
        shipDetail.setAvailability(false);

        assertEquals(2L, shipDetail.getShipId(), "Ship ID should be updated to 2");
        assertEquals("Ship B", shipDetail.getName(), "Ship name should be updated to Ship B");
        assertEquals("Port C", shipDetail.getSource(), "Source should be updated to Port C");
        assertEquals("Port D", shipDetail.getDestination(), "Destination should be updated to Port D");
        assertEquals(600, shipDetail.getCruiseLength(), "Cruise length should be updated to 600");
        assertEquals(4.8f, shipDetail.getRating(), "Rating should be updated to 4.8");
        assertFalse(shipDetail.getAvailability(), "Availability should be updated to false");
    }

    @Test
    void testCapacityIsImmutable() {
        int capacity = shipDetail.getCapacity();
        assertEquals(200, capacity, "Capacity should always be 200 and immutable");
    }

    @Test
    void testPriceIsImmutable() {
        float price = shipDetail.getPrice();
        assertEquals(1000f, price, "Price should always be 1000 and immutable");
    }

    @Test
    void testDateFormat() {
        Date date = shipDetail.getDate();
        assertNotNull(date, "Date should be properly set");
    }
}
