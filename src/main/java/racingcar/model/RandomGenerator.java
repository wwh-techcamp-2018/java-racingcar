package racingcar.model;


import java.util.Random;

public class RandomGenerator implements Generator {
    @Override
    public int generate() {
        return new Random().nextInt(10);
    }
}
