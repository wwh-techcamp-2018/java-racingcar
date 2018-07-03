package game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RacingGameTest {
    private RacingGame racingGame;

    @Before
    public void setUp() {
        String str = "pobi,crong,honux";
        String[] splitedString = str.split(",");
        racingGame = new RacingGame(1, splitedString);
    }

    @Test
    public void findWinnerPositionTest() {
        List<Car> carList = racingGame.getCars();
        carList.get(0).movePosition(5);
        carList.get(1).movePosition(4);
        carList.get(2).movePosition(3);

        List<String> stringList = new ArrayList<>();
        stringList.add("pobi : -");
        stringList.add("crong : -");
        stringList.add("honux : ");

        assertEquals(stringList, racingGame.trackResultWithName());
    }
}