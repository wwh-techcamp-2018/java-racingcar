package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        String[] names = {"minseok", "hyeona"};
        racingGame = new RacingGame(names);
    }
//
//    @Test
//    public void getRoad() {
//        assertEquals("---------", racingGame.getRoad(9));
//    }

    @Test
    public void max() {
        assertThat(racingGame.max(1, 2)).isEqualTo(2);
    }

}