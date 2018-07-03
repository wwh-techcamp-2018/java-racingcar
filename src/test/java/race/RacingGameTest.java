package race;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RacingGameTest {

    private RacingGame newGame;
    private List<Car> cars;
    private List<Car> winners;

    @Before
    public void setUp() {
        newGame = new RacingGame(new String[] { "pobi", "crong", "honux" });

        cars = new ArrayList<>();
        winners = new ArrayList<>();

        Car looser = new Car("looser");

        for (int i = 0; i < 4; i++) {
            Car winner = new Car("winner");
            winner.moveFront();

            cars.add(winner);
            winners.add(winner);
        }

        cars.add(looser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numOfCarsShouldPositiveNumber() {
        new RacingGame(new String[]{ });
    }

    @Test
    public void chooseCorrectWinners() {
        assertThat(newGame.chooseWinners(cars)).isEqualTo(winners);
    }

    @Test
    public void chooseCorrectWinnersWhenOnlyOneCar() {
        List<Car> oneCarList = new ArrayList<>();
        oneCarList.add(new Car("only_one"));
        assertThat(newGame.chooseWinners(oneCarList)).isEqualTo(oneCarList);
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