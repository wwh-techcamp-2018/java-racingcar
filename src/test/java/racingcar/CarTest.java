package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp(){
        car = new Car("a,b,c");
    }

    @Test
    public void moveFailed() {
        assertEquals(0, car.moveWithCondition(3));
    }

    @Test
    public void moveSucceed() {
        assertEquals(1, car.moveWithCondition(Car.FORWARD_NUM));
    }

    @Test
    public void isReached() {
        assertEquals(true, car.isReached(0));
    }
}