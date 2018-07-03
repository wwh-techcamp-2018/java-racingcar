package racing;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RacingTest {
    @Test
    public void buildDashTest() {
        assertEquals("-----", Racing.buildDash(5));
    }

    @Test
    public void buildWinnerMessage() {
        ArrayList<Car> winners = new ArrayList<>();
        winners.add(new Car("yeon"));
        winners.add(new Car("junsu"));
        assertEquals("yeon, junsu가 최종 우승했습니다.", Racing.buildWinnerMessage(winners));
    }

    @Test
    public void buildResult() {
        Car car = new Car("yeon");

        // 4 이상의 숫자를 넣으면 position이 ++된다.
        car.move(5);
        car.move(5);
        assertEquals("yeon : --", Racing.buildResult(car));
    }

    @Test
    public void parseCarNameTest() {
        String names = "porbi,prodo,crong,honux";
        ArrayList<String> carNames = new ArrayList<>();
        carNames.add("porbi");
        carNames.add("prodo");
        carNames.add("crong");
        carNames.add("honux");
        assertEquals(carNames, Racing.parseCarNames(names));
    }

}