package racing;

import java.util.Random;

public class RandomValueGenerator {
    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
