package racingcar.utils;

import java.util.Random;

public class RandomGenerator implements Generator {
    static Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(TICKET_UPPER_BOUND + 1);
    }
}
