package racingcar.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("포비");
    }

    @Test
    public void carMoveFail() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void carMoveSuccess() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}