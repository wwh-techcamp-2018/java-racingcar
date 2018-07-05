package utility;

import java.util.Random;

public class RandomGenerator {

    public static int generate(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
