import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.CESSNA);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.CESSNA, plane.getPlaneType());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(5, plane.getCapacity());
    }

    @Test
    public void canGetPlaneWeight(){
        assertEquals(200, plane.getWeight());
    }
}
