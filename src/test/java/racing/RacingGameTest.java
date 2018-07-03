package racing;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class RacingGameTest {

    private RacingGame rg;
    private String[] name;

    @Before
    public void setUp() throws Exception {
        name = new String[]{"pobi", "crong"};
        rg = new RacingGame(name);
    }

    @Test
    public void getWinner() {
        List<Car> list = rg.getCars();
        list.get(0).move(9);
        list.get(0).move(9);
        list.get(1).move(2);
        list.get(1).move(2);

        List winner = rg.getWinner();
        assertEquals("pobi가 최종 우승했습니다.", rg.printWinner(winner));
    }
  
    @Test
    public void init() {
        assertEquals(2, rg.cars.size());
    }
}