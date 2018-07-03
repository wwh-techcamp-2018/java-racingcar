package utility;

import java.util.List;

public class StringUtility {
    private final static String SPACE = " ";
    private final static String COMMA = ",";
    private final static String DASH = "-";

    public static String repeatDash(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public static String[] splitWithComma(String input) {
        return input.split(COMMA);
    }

    public static String joinWithComma(List<String> items) {
        StringBuffer sb = new StringBuffer();
        for (String item : items) {
            sb.append(item);
            sb.append(COMMA);
            sb.append(SPACE);
        }
        return sb.substring(0, sb.length() - 2);
    }
}
