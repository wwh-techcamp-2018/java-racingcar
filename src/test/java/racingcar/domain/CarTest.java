package racingcar.domain;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp(){
        car = new Car("TestCar", 2);
    }

    @Test
    public void moveFailed() {
        assertEquals(2, car.moveWithCondition(3));
    }

    @Test
    public void moveSucceed() {
        assertEquals(3, car.moveWithCondition(Car.FORWARD_NUM));
    }

    @Test
    public void isReached() { assertEquals(true, car.isReached(2)); }

}