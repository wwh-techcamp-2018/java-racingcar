package racingcar.domain;

import org.junit.Before;
import org.junit.Test;
import racingcar.dto.Entry;
import racingcar.dto.RacingGameInput;
import racingcar.dto.RacingGameResult;
import racingcar.utils.RandomGenerator;
import racingcar.utils.StaticGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingGameInput gameInput;

    @Before
    public void setUp() throws Exception {
        String[] names = {"광일", "선영"};
        gameInput = new RacingGameInput(names, 5);
    }

    @Test
    public void constructor() {
        RacingCarGame racingCarGame = new RacingCarGame(gameInput, new RandomGenerator());
        assertThat(racingCarGame.getCars())
                .contains(new Car("광일"))
                .contains(new Car("선영"));
    }

    // TODO: 2018. 7. 5. 아래 두 테스트 모듈을 작성해야합니다.
    @Test
    public void staticRun() {

    }

    @Test
    public void getWinners() {

    }
}