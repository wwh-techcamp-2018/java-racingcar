package racing;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void successMove() {
        Car car = new Car();
        assertEquals(1, car.move(5));
    }

    @Test
    public void failMove() {
        Car car = new Car();
        assertEquals(0, car.move(2));
    }
}