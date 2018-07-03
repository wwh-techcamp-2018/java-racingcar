package race;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {

    private RacingGame newGame;

    @Before
    public void setUp() throws Exception {
        newGame = new RacingGame(new String[] { "pobi", "crong", "honux" }, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void timeShouldPositiveNumber() {
        new RacingGame(new String[] { "pobi", "crong", "honux" }, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numOfCarsShouldPositiveNumber() {
        new RacingGame(new String[]{ }, 2);
    }

    @Test
    public void shouldNotBeMoved() {
        assertThat(newGame.move(0, 3).get(0).getPosition()).isZero();
    }

    @Test
    public void shouldBeMoved() {
        assertThat(newGame.move(1, 4).get(1).getPosition()).isOne();
    }
}