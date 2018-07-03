package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameManagerTest {
    private RacingGameManager racingGameManager;
    private String[] names;

    @Before
    public void setUp() throws Exception {
        racingGameManager = new RacingGameManager();
        names = new String[]{"pobi", "crong", "honux"};
    }

    @Test
    public void initGameTest() {
        assertThat(racingGameManager.initGame(names)).isEqualTo(3);
    }

    @Test
    public void sortTest() {
        racingGameManager.initGame(names);
        racingGameManager.moveCars(5);
        racingGameManager.sort();
        racingGameManager.printResult();
    }

    @Test
    public void judgeWinnerTest() {
        Car car = new Car("pobi");
        assertThat(racingGameManager.judgeWinner(car, 1)).isEqualTo(false);

        car.move(5);
        assertThat(racingGameManager.judgeWinner(car, 1)).isEqualTo(true);
    }

    @Test
    public void runGameTest() {
        racingGameManager.initGame(names);
        racingGameManager.runGame(5);
    }
}