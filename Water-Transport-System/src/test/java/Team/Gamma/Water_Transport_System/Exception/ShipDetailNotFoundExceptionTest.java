
package Team.Gamma.Water_Transport_System.Exception;


import static org.junit.jupiter.api.Assertions.*;

import Team.Gamma.Water_Transport_System.Exception.ShipDetailNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShipDetailNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        String expectedMessage = "Ship details not found!";
        ShipDetailNotFoundException exception = new ShipDetailNotFoundException(expectedMessage);
        assertEquals(expectedMessage, exception.getMessage(), "Exception message should match the expected message.");
    }

    @Test
    void testExceptionType() {
        String expectedMessage = "Ship details not found!";
        ShipDetailNotFoundException exception = new ShipDetailNotFoundException(expectedMessage);
        assertTrue(exception instanceof RuntimeException, "Exception should be of type RuntimeException");
    }
}
