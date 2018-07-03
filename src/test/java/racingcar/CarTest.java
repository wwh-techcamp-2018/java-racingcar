package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void moveFailed() {
        int prePos = car.getPosition();
        car.moveWithCondition(3);
        int postPos = car.getPosition();
        assertEquals(postPos, prePos);
    }

    @Test
    public void moveSucceed() {
        int prePos = car.getPosition();
        car.moveWithCondition(Car.FORWARD_NUM);
        int postPos = car.getPosition();
        assertEquals(prePos + 1, postPos);
    }
}