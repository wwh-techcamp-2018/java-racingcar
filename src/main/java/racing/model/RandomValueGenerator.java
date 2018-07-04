package racing.model;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator{
    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
