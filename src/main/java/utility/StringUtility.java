package utility;

public class StringUtility {
    private final static String DASH = "-";

    public static String repeatDash(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }
}
