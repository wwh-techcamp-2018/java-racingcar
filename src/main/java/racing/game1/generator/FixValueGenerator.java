package racing.game1.generator;

public class FixValueGenerator implements ValueGenerator{

    private int value = 4;

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int nextInt() {
        return value;
    }
}
