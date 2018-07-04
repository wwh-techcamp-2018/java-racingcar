package racing.game1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WinnerTest {

    private Car car;
    private Car standardCar;
    private Winner winner;

    @Before
    public void setUp() throws Exception {
        car = new Car("pobi",3);
        standardCar = new Car("crong",2);
    }

//    @Test
//    public void isWinFail() {
//        winner.changeWinnersStateWithWin(car);
//        assertEquals("crong가 최종 우승했습니다.", winner.getWinners().toString());
//    }
//
//    @Test
//    public void isWinSuccess() {
//        Car car = new Car("pobi",3);
//        winner.changeWinnersStateWithWin(car);
//        assertEquals("pobi가 최종 우승했습니다.", winner.getWinners().toString());
//    }
//
//    @Test
//    public void isDrawFailWithUpperHighScore() {
//        Car car = new Car("pobi",3);
//        winner.changeWinnersStateWithDraw(car);
//        assertEquals("crong가 최종 우승했습니다.", winner.getWinners().toString());
//    }
//
//    @Test
//    public void isDrawFailWithLowerHighScore() {
//        winner.changeWinnersStateWithDraw(car);
//        assertEquals("crong가 최종 우승했습니다.", winner.getWinners().toString());
//    }
//
//    @Test
//    public void isDrawSuccess() {
//        Car car = new Car("pobi",2);
//        winner.changeWinnersStateWithDraw(car);
//        assertEquals("crong,pobi가 최종 우승했습니다.", winner.getWinners().toString());
//    }

    @Test
    public void getMaxPositionTest() {
        assertEquals(3, Winner.getMaxPosition(Arrays.asList(standardCar,car)));
    }

    @Test
    public void getWinnersTest() {
        assertEquals("pobi",Winner.getWinners(Arrays.asList(car,standardCar),3));
    }
}