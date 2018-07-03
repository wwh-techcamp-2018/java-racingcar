package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    /**
     * 메소드 단위 테스트(단위테스트) -> 클래스 단위테스트?
     * 1. 전진할지 멈출할지 테스트
     *
     * 추측 :
     */
    private RacingCar racingCar;

    @Before
    public void setUp() throws Exception {
        racingCar = new RacingCar();

    }

    @Test
    public void 출력() {
        assertThat(racingCar.makePositionToString(1)).isEqualTo("-");
    }


    @Test
    public void 이동테스트() {
        assertThat(racingCar.move(4)).isEqualTo(1);
    }
}