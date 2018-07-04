package race;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car firstCar;
    private Car secondCar;

    @Before
    public void setUp() {
        firstCar = new Car("car1");
        secondCar = new Car("car2");
    }

    @Test
    public void moveFront() {
        assertThat(firstCar.moveFront()).isOne();
    }

    @Test
    public void isOnPosition() {
        firstCar.moveFront();
        secondCar.moveFront();
        assertThat(firstCar.isOnPosition(secondCar)).isTrue();
    }

    @Test
    public void isNotOnPosition() {
        secondCar.moveFront();
        assertThat(firstCar.isOnPosition(secondCar)).isFalse();
    }

    @Test
    public void getWinner() {
        firstCar.moveFront();

        assertThat(firstCar.getWinner(secondCar)).isEqualTo(firstCar);
    }
}