package Team.Gamma.Water_Transport_System.Dto;

import Team.Gamma.Water_Transport_System.Entity.ShipDetail;
import Team.Gamma.Water_Transport_System.Entity.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptDTOTest {

    @Test
    void testGettersAndSetters() {
        // Create a ReceiptDTO instance
        ReceiptDTO receiptDTO = new ReceiptDTO();

        // Test Receipt ID
        Long expectedReceiptId = 101L;
        receiptDTO.setReceiptId(expectedReceiptId);
        assertEquals(expectedReceiptId, receiptDTO.getReceiptId(), "Receipt ID should match the value set");

        // Test Amount
        int expectedAmount = 1500;
        receiptDTO.setAmount(expectedAmount);
        assertEquals(expectedAmount, receiptDTO.getAmount(), "Amount should match the value set");

        // Test Date
        Date expectedDate = new Date();
        receiptDTO.setDate(expectedDate);
        assertEquals(expectedDate, receiptDTO.getDate(), "Date should match the value set");

        // Test User
        User expectedUser = new User();
        expectedUser.setUserid(1L); // Example value
        receiptDTO.setUser(expectedUser);
        assertEquals(expectedUser, receiptDTO.getUser(), "User should match the value set");

        // Test ShipDetail
        ShipDetail expectedShip = new ShipDetail();
        expectedShip.setShipId(201L); // Example value
        receiptDTO.setShip(expectedShip);
        assertEquals(expectedShip, receiptDTO.getShip(), "ShipDetail should match the value set");
    }

    @Test
    void testDefaultValues() {
        // Create a ReceiptDTO instance
        ReceiptDTO receiptDTO = new ReceiptDTO();

        // Assert default values are null or zero
        assertNull(receiptDTO.getReceiptId(), "Default Receipt ID should be null");
        assertEquals(0, receiptDTO.getAmount(), "Default amount should be 0");
        assertNull(receiptDTO.getDate(), "Default date should be null");
        assertNull(receiptDTO.getUser(), "Default user should be null");
        assertNull(receiptDTO.getShip(), "Default ship should be null");
    }

    @Test
    void testNullValues() {
        // Create a ReceiptDTO instance
        ReceiptDTO receiptDTO = new ReceiptDTO();

        // Set null values
        receiptDTO.setReceiptId(null);
        receiptDTO.setDate(null);
        receiptDTO.setUser(null);
        receiptDTO.setShip(null);

        // Assert null values
        assertNull(receiptDTO.getReceiptId(), "Receipt ID should be null when set to null");
        assertNull(receiptDTO.getDate(), "Date should be null when set to null");
        assertNull(receiptDTO.getUser(), "User should be null when set to null");
        assertNull(receiptDTO.getShip(), "Ship should be null when set to null");
    }

    @Test
    void testUpdatingValues() {
        // Create a ReceiptDTO instance
        ReceiptDTO receiptDTO = new ReceiptDTO();

        // Set initial values
        receiptDTO.setReceiptId(100L);
        receiptDTO.setAmount(2000);

        // Update values
        receiptDTO.setReceiptId(101L);
        receiptDTO.setAmount(2500);

        // Assert updated values
        assertEquals(101L, receiptDTO.getReceiptId(), "Updated Receipt ID should match");
        assertEquals(2500, receiptDTO.getAmount(), "Updated amount should match");
    }

    @Test
    void testEmptyUserAndShip() {
        // Create a ReceiptDTO instance
        ReceiptDTO receiptDTO = new ReceiptDTO();

        // Create empty User and ShipDetail
        User emptyUser = new User();
        ShipDetail emptyShip = new ShipDetail();

        // Set empty User and ShipDetail
        receiptDTO.setUser(emptyUser);
        receiptDTO.setShip(emptyShip);

        // Assert empty User and ShipDetail
        assertEquals(emptyUser, receiptDTO.getUser(), "User should allow setting an empty User object");
        assertEquals(emptyShip, receiptDTO.getShip(), "Ship should allow setting an empty ShipDetail object");
    }
}
