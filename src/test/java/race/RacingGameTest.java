package race;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {

    private RacingGame newGame;

    @Before
    public void setUp() throws Exception {
        newGame = new RacingGame(3, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void timeShouldPositiveNumber() {
        new RacingGame(2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numOfCarsShouldPositiveNumber() {
        new RacingGame(0, 2);
    }

    @Test
    public void repeat() {
        assertThat(RacingGame.repeat(1).length()).isOne();
    }

    @Test
    public void shouldNotBeMoved() {
        assertThat(newGame.move(0, 3)[0]).isZero();
    }

    @Test
    public void shouldBeMoved() {
        assertThat(newGame.move(1, 4)[1]).isOne();
    }
}