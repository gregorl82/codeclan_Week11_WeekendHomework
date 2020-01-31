import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;
    private Passenger passenger4;
    private GregorianCalendar departureTime;
    private ArrayList<Integer> expectedSeatNumbers;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);

        passenger1 = new Passenger("Bobby Blue", 2);
        passenger2 = new Passenger("Yoann Yellow", 2);
        passenger3 = new Passenger("Polly Purple", 2);
        passenger4 = new Passenger("Michael Mauve", 1);

        departureTime = new GregorianCalendar(2020, 1, 1, 8, 0);

        flight = new Flight("AB123", Airport.EDI, Airport.GLA, plane, departureTime);

        flightManager = new FlightManager();

        expectedSeatNumbers = new ArrayList<>();
        expectedSeatNumbers.add(1);
        expectedSeatNumbers.add(2);
        expectedSeatNumbers.add(3);
        expectedSeatNumbers.add(4);
    }

    @Test
    public void canCalculateAvailableWeightForBaggage(){
        assertEquals(160, flightManager.getTotalAvailableWeight(flight));
    }

    @Test
    public void canCalculatePassengersBaggageWeight(){
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger1);
        assertEquals(80, flightManager.getWeightOfPassengerBaggage(flight));
    }

    @Test
    public void canCalculateRemainingWeightForBaggage(){
        flight.bookPassenger(passenger1);
        assertEquals(120, flightManager.getRemainingWeightForBaggage(flight));
    }

    @Test
    public void outputSortedPassengerNumbers(){
        // Book in 4 passengers and sort by seat number
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        flightManager.sortPassengersBySeatNumber(flight);

        // Pull out seat numbers and assign to a new ArrayList
        ArrayList<Integer> output = new ArrayList<>();
        for(Passenger passenger : flight.getPassengers()){
            output.add(passenger.getSeatNumber());
        }

        // Check against [1, 2, 3, 4]
        assertEquals(expectedSeatNumbers, output);
    }
}
