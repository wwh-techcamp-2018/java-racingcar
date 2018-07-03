package racing;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    public void move() {
        Car car = new Car();
        assertThat(car.move(5)).isEqualTo(1);
    }

    @Test
    public void getDistance() {
        Car car = new Car();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}