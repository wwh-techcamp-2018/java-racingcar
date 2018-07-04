package racingcar;

import org.junit.Before;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("minseok", 2);
    }

//    @Test
//    public void move() {
//        assertThat(car.move(4)).isEqualTo(3);
//    }
//
//    @Test
//    public void stop() {
//        assertThat(car.move(3)).isEqualTo(2);
//    }
//
//    @Test
//    public void getRoad() {
//        assertThat(car.getRoad()).isEqualTo("--");
//    }
}