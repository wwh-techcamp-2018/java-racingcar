package car.model;

import car.model.Car;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CarTest {

    Car car;
    NamedCar namedCar;

    @Before
    public void setUp() {
        car = new Car();
        namedCar = new NamedCar("temp");
    }

    @Test
    public void moveACar움직이지않는경우() {
        assertEquals(0, car.move(3));
    }

    @Test
    public void moveACar움직이는경우() {
        assertEquals(1, car.move(4));
    }

    @Test
    public void moveANamedCar움직이지않는경우() {
        assertEquals(0, namedCar.move(3));
    }

    @Test
    public void moveANamedCar움직이는경우() {
        assertEquals(1, namedCar.move(4));
    }

}
