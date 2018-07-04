package adder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser implements Parser {
    private static final String DEFAULT_DELIMITER = "[,:]";

    public String[] parse(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) return parseByDelimiter(m.group(2), m.group(1));
        return parseByDelimiter(text, DEFAULT_DELIMITER);
    }

    public static String[] parseByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }
}
