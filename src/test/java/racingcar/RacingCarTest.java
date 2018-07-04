package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    /**
     * 메소드 단위 테스트(단위테스트) -> 클래스 단위테스트?
     * 1. 전진할지 멈출할지 테스트
     * 2. 우승자 확인 테스트
     */
    private RacingCar racingCar;

    @Before
    public void setUp() throws Exception {
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
    public void 우승자_확인() {
        RacingCar pobiCar = new RacingCar("pobi", 5);
        RacingCar honuxCar = new RacingCar("honux", 6);
        RacingCar crongCar = new RacingCar("crong", 6);

        List<RacingCar> racingCars = Arrays.asList(
                pobiCar
                , honuxCar
                , crongCar
        );

        assertThat(RacingGame.makeWinners(racingCars))
                .contains(crongCar)
                .contains(honuxCar)
                .doesNotContain(pobiCar);
    }
}