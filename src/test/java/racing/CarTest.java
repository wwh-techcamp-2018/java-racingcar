package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void move() {
        Car car = new Car();
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(4)).isEqualTo(2);
        assertThat(car.move(3)).isEqualTo(2);
    }

    @Test
    public void getDistance() {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}