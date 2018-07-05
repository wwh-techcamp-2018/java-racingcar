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

        String delimiter = extractDelimiter();

        int[] intArray = convertStringArrayToIntArray(splitString(delimiter));

        return intArray;
    }

    public String extractDelimiter() {
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

    public static int[] convertStringArrayToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray)
                .mapToInt(StringParser::toPositiveInteger)
                .toArray();
    }

    public static int toPositiveInteger(String numString) {
        int result = Integer.parseInt(numString);

        if (result < 0) {
            throw new RuntimeException();
        }

        return result;
    }
}
