package sum;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    public static final String DEFAULT_DELIMITER = ":|,";
    public static final String EXTRACT_CHARACTER_PATTERN = "//(.)\n(.*)";

    private String text;

    public StringParser(String text) {
        this.text = text;
    }

    public int[] generateNumber() {
        if (text == null || text.length() == 0) {
            return new int[]{0};
        }

        String delimiter = extractDelimeter();

        return stringArrayToIntArray(splitString(delimiter));
    }

    public String extractDelimeter() {
        Matcher m = Pattern.compile(EXTRACT_CHARACTER_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            text = m.group(2);
            return customDelimiter;
        }

        return DEFAULT_DELIMITER;
    }

    public String[] splitString(String delimiter) {
        return text.split(delimiter);
    }

    public static int[] stringArrayToIntArray(String[] stringArray) {
        int[] intArray=  Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i : intArray) {
            isPositiveInteger(i);
        }

        return intArray;
    }

    public static void isPositiveInteger(int number) {
        if (number <= 0) {
            throw new RuntimeException();
        }
    }
}
