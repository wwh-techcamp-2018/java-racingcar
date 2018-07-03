package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(3);
    }

    @Test
    public void getRoad() {
        assertEquals("---------", RacingGame.getRoad(9));
    }

    @Test
    public void max() {
        assertThat(racingGame.max(1, 2)).isEqualTo(2);
    }

}