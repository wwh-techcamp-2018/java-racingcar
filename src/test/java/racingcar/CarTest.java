package racingcar;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(0);
    }

    @Test
    public void move() {
        assertThat(car.move(4)).isEqualTo(1);
    }

    @Test
    public void stop() {
        assertThat(car.move(3)).isEqualTo(0);
    }
}