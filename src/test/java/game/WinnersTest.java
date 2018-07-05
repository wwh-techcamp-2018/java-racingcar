package game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WinnersTest {

    private List<Car> carList;
    private Winner winners;

    @Before
    public void setUp() {
        winners = new Winner();
        carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("honux"));
    }

    @Test
    public void findWinnerPosition() {
        carList.get(0).movePosition(6);
        carList.get(0).movePosition(2);
        carList.get(1).movePosition(3);
        carList.get(2).movePosition(2);
        carList.get(2).movePosition(5);

        assertEquals(2, winners.findWinnerPosition(carList));

    }

    @Test
    public void stringWinners() {
        carList.get(0).movePosition(1);
        carList.get(1).movePosition(4);
        carList.get(2).movePosition(6);

        winners.findWinnerPosition(carList);
        String testString = "crong, honux가 최종 우승했습니다.";
        winners.findWinnersName(carList);

        assertEquals(testString, winners.winnersToString());
    }
}