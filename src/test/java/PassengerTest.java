import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Roger Red", 2);
    }

    @Test
    public void canGetPassengerName(){
        assertEquals("Roger Red", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void passengerFlightStartsNull(){
        Assert.assertNull(passenger.getFlight());
    }

    @Test
    public void canSetPassengerFlight(){
        passenger.setFlight("BA151");
        assertEquals("BA151", passenger.getFlight());
    }
}
