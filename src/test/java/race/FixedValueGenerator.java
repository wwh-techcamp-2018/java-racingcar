package race;

public class FixedValueGenerator implements ValueGenerator {
    private final int value;
    public FixedValueGenerator(int value) {
        this.value = value;
    }


    @Override
    public int generate() {
        return value;
    }
}
