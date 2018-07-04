package racingcar.random;

import java.util.Random;

public class RealRandomGenerator implements RandomGenerator {
    @Override
    public int generate(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }
}
