package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RacingCarGameTest {

    private RacingCarGame game;

    @Before
    public void setUp() throws Exception {
        String[] names = {"호눅스", "크롱", "포비"};
        game = new RacingCarGame(names);
    }
}