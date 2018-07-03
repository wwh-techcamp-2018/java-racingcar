package racing;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RacingTest {
    @Test
    public void buildDashTest() {
        assertEquals("-----", RacingUtil.buildDash(5));
    }

    @Test
    public void buildResult() {
        Car car = new Car("yeon");

        // 4 이상의 숫자를 넣으면 position이 ++된다.
        car.move(5);
        car.move(5);
        assertEquals("yeon : --", RacingUtil.buildResult(car));
    }

    @Test
    public void parseCarNameTest() {
        String names = "porbi,prodo,crong,honux";
        String[] carNames = {"porbi", "prodo", "crong", "honux"};
        assertArrayEquals(carNames, RacingUtil.parseCarNames(names));
    }

    @Test
    public void getMaxPosition() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("hi"));
        cars.add(new Car("hello"));

        cars.get(0).move(5);
        cars.get(0).move(5);
        assertEquals(2, RacingUtil.getMaxPosition(cars));
    }

}