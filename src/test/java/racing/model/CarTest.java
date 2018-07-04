package racing.model;

import org.junit.Before;
import org.junit.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private String name;

    @Before
    public void setUp() throws Exception {
        name = "pobi";
    }

    @Test
    public void moveTest() {
        Car car = new Car(name);
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(4)).isEqualTo(2);
        assertThat(car.move(3)).isEqualTo(2);
    }

    @Test
    public void getDistanceTest() {
        Car car = new Car(name);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    public void compareTest() {
        Car car1 = new Car(name);
        Car car2 = new Car(name);
        assertThat(car1.compareTo(car2)).isEqualTo(0);

        car1.move(5);
        assertThat(car1.compareTo(car2)).isEqualTo(-1);
    }
}