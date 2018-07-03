package racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameManagerTest {
    private RacingGameManager racingGameManager;
    @Before
    public void setUp() throws Exception {
        racingGameManager = new RacingGameManager();
    }

    @Test
    public void initGame() {
        assertThat(racingGameManager.initGame(3)).isEqualTo(3);
    }

    @Test
    public void runGame() {
        racingGameManager.initGame(3);
        racingGameManager.runGame(5);
    }
}