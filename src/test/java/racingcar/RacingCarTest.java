package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    /**
     * 메소드 단위 테스트(단위테스트) -> 클래스 단위테스트?
     * 1. 전진할지 멈출할지 테스트
     * 2. 우승자 확인 테스트
     */
    private RacingGame racingGame;
    private RacingCar racingCar;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame("pobi,crong");
        racingCar = new RacingCar("pobi");

    }

    @Test
    public void 출력() {
        assertThat(racingCar.makePositionToString(1)).isEqualTo("-");
    }


    @Test
    public void 이동테스트() {
        assertThat(racingCar.move(4)).isEqualTo(1);
    }

    @Test
    public void 우승자확인() {
        List<RacingCar> racingCars = racingGame.getCars();
        racingCars.get(0).move(2);
        racingCars.get(1).move(5);
        assertThat(racingGame.checkWinners().get(0)).isEqualTo("crong");
    }
}