package racing.game1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"});
    }

    @Test
    public void getWinnerWithSingleWinner() {
        for (int i = 0; i < 3; i++) {
            racingGame.getCars().get(i).setPosition(i);
        }
        assertEquals("honux가 최종 우승했습니다.",
                racingGame.getWinner((ArrayList) racingGame.getCars()));
    }

    @Test
    public void getWinnerWithCowinner() {
        for (int i = 0; i < 3; i++) {
            racingGame.getCars().get(i).setPosition(0);
        }
        assertEquals("pobi,crong,honux가 최종 우승했습니다.",
                racingGame.getWinner((ArrayList) racingGame.getCars()));
    }
}