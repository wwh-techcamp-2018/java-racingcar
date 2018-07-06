package racingcar.domain;

import org.junit.Test;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @Test (expected = NullPointerException.class)
    public void setNullCarNames() {
        new RacingGame(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void setEmptyCarNames() {
        new RacingGame("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void runNegativeTimes() {
        new RacingGame("a").run(-1);
    }

}