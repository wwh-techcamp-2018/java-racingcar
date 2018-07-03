package coordinate;

public class PointParser {
    int[] parse(String text) {
        String escape = text.substring(1, text.length() - 1);
        String[] values = escape.split(",");
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }
}
