package stringcalculator;

public class Positive {
    int convertPositiveInt(String value) {
        int result;
        try {
            result = Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        if (result < 0)
            throw new RuntimeException();

        return result;
    }
}
