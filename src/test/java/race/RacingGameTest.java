package race;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {
    private static int TIME = 5;

    private RacingGame newGame;

    @Before
    public void setUp() {
        newGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, new FixedValueGenerator(5));
    }

    @Test
    public void play() {
        RacingResult result = newGame.play(TIME);
        assertThat(result.getResultMap()).containsKeys("pobi", "crong", "honux");
        assertThat(result.getWinners())
                .contains("pobi", "crong", "honux");
    }

    @Test(expected = IllegalArgumentException.class)
    public void numOfCarsShouldPositiveNumber() {
        new RacingGame(new String[]{});
    }

    @Test
    public void chooseCorrectWinners() {
        assertThat(RacingGame.chooseWinners(Arrays.asList(
                new Car("winner1", 3),
                new Car("winner2", 3),
                new Car("looser", 2))))
                .contains("winner1", "winner2")
                .doesNotContain("looser");
    }

    @Test
    public void chooseCorrectWinnersWhenOnlyOneCar() {
        List<Car> oneCarList = new ArrayList<>();
        oneCarList.add(new Car("only_one"));
        assertThat(RacingGame.chooseWinners(oneCarList)).isEqualTo(Arrays.asList("only_one"));
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