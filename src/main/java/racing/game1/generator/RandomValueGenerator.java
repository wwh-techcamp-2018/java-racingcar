package racing.game1.generator;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {

    private static final Random value = new Random();

    @Override
    public int nextInt() {
        return value.nextInt(10);
    }
}
