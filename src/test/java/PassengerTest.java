import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        assertNull(passenger.getFlight());
    }

    @Test
    public void canSetPassengerFlight(){
        passenger.setFlight("BA151");
        assertEquals("BA151", passenger.getFlight());
    }

    @Test
    public void passengerSeatNumberStartsZero(){
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void canSetPassengerSeatNumber(){
        passenger.setSeatNumber(5);
        assertEquals(5, passenger.getSeatNumber());
    }
}
