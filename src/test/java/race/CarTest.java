package race;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void moveFront() {
        assertThat(new Car("temp").moveFront()).isOne();
    }
}