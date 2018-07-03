package racing;

public class StaticValueGenerator extends RandomValueGenerator {
    private int value;

    public StaticValueGenerator(int value) {
        this.value = value;
    }

    @Override
    public int getRandomValue() {
        return this.value;
    }
}
