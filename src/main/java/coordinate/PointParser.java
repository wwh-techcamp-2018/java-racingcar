package coordinate;

public class PointParser {
    static int[] parse(String text) {
        String escape = text.substring(1, text.length() - 1);
        String[] values = escape.split(",");
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number > 24) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
