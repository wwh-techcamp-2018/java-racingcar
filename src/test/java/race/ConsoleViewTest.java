package race;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ConsoleViewTest {
    private ConsoleView consoleView;

    @Before
    public void setUp() {
        consoleView = new ConsoleView();
    }

    @Test
    public void generateCarTiles() {
        assertThat(ConsoleView.generateCarTiles(1).length()).isOne();
    }

    @Test
    public void generateWinners() {
        assertThat(consoleView.generateWinners(Arrays.asList("winner1", "winner2")))
                .isEqualTo("winner1, winner2가 최종 우승했습니다.");
    }

    @Test
    public void parseValidCarNames() {
        assertThat(consoleView.parseCarNames("a, b, c, d"))
                .isEqualTo(new String[]{"a", "b", "c", "d"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyCarNames() {
        consoleView.parseCarNames("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNullCarNames() {
        consoleView.parseCarNames(null);
    }
}