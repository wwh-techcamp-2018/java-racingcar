package racing.game1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("pobi");
    }

    @Test
    public void moveFail() {
        car.move(3);
        assertEquals(0, car.getPosition());
    }

    @Test
    public void moveSuccess() {
        car.move(4);
        assertEquals(1, car.getPosition());
    }

    @Test
    public void getState() {
        assertEquals("---", Car.getState(3));
    }

    @Test
    public void isWinTrue() {
        car.move(4);
        assertEquals(true,car.isWin(0));
    }


    @Test
    public void isWinFalse() {
        assertEquals(false,car.isWin(0));
    }

    @Test
    public void isDrawFalseWithUpperScore() {
        car.move(4);
        assertEquals(false,car.isDraw(0));
    }

    @Test
    public void isDrawFalseWithLowerScore() {
        assertEquals(false,car.isDraw(1));
    }

    @Test
    public void isDrawTrue() {
        assertEquals(true,car.isDraw(0));
    }
}