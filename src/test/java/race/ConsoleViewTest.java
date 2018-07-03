package race;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ConsoleViewTest {
    private ConsoleView consoleView;
    private List<Car> cars;

    @Before
    public void setUp() {
        consoleView = new ConsoleView();
        cars = new ArrayList<>();
        cars.add(new Car("winner1"));
        cars.add(new Car("winner2"));
    }

    @Test
    public void generateCarTiles() {
        assertThat(ConsoleView.generateCarTiles(1).length()).isOne();
    }

    @Test
    public void gererateWinners() {
        assertThat(consoleView.gererateWinners(cars))
                .isEqualTo("winner1, winner2가 최종 우승했습니다.");
    }

    @Test
    public void parseValidCarNames() {
        assertThat(consoleView.parseCarNames("a, b, c, d"))
                .isEqualTo(new String[]{"a", "b", "c", "d"});
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseEmptyCarNames() {
        consoleView.parseCarNames("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void parseNullCarNames() {
        consoleView.parseCarNames(null);
    }
}