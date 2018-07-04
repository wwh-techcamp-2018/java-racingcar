package stringcalculator;

public class DefaultSplit extends Split {
    private static final String DEFAULT_SPLITTER = ",|:";

    @Override
    String getSpliter() {
        return DEFAULT_SPLITTER;
    }

    @Override
    String[] split(String value) {
        return super.splitInternal(value);
    }
}
