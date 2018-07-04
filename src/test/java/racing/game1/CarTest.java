package racing.game1;

import org.junit.Before;
import org.junit.Test;
import racing.game1.generator.FixValueGenerator;

import static org.junit.Assert.*;

public class CarTest {

    private Car car;
    private FixValueGenerator vg;

    @Before
    public void setUp() throws Exception {
        vg = new FixValueGenerator();
        car = new Car("pobi",vg);
    }

    @Test
    public void moveFail() {
        vg.setValue(3);
        car.move();
        assertEquals(0, car.getPosition());
    }

    @Test
    public void moveSuccess() {
        car.move();
        assertEquals(1, car.getPosition());
    }

    @Test
    public void getState() {
        assertEquals("---", Car.getState(3));
    }

    @Test
    public void isWinTrue() {
        car.move();
        assertEquals(true,car.isWin(0));
    }


    @Test
    public void isWinFalse() {
        assertEquals(false,car.isWin(0));
    }

    @Test
    public void isDrawFalseWithUpperScore() {
        car.move();
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

    @Test
    public void appendWinnerTestWithEmpty() {
        assertEquals("pobi" ,car.appendWinner(new StringBuilder()).toString());
    }

    @Test
    public void appendWinnerTest() {
        assertEquals("crong,pobi" ,car.appendWinner(new StringBuilder("crong")).toString());
    }

    @Test
    public void getMaxPositionTest() {
        assertEquals(4,car.getMaxPosition(4));
    }

    @Test
    public void getMaxPositionTestWithLowerNumber() {
        assertEquals(0,car.getMaxPosition(-1));
    }

    @Test
    public void isWinnerTest() {
        assertEquals(true,car.isWinner(0));
    }

    @Test
    public void isWinnerFailTest() {
        assertEquals(false,car.isWinner(-1));
    }

}