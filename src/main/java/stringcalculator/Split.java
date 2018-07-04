package stringcalculator;

public abstract class Split {
    public static final String[] ZERO_RESULT = new String[]{"0"};


    public String[] splitInternal(String value) {
        if (isBlank(value))
            return ZERO_RESULT;
        return value.split(getSpliter());
    }

    private static boolean isBlank(String value) {
        return value == null || value.length() == 0;
    }

    abstract String getSpliter();
    abstract String[] split(String value);



}
