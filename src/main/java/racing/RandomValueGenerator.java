package racing;

import java.util.Random;

public class RandomValueGenerator {
    public static final int BOUND = 10;

    public int getRandomValue() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
