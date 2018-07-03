package util;

public class StringUtil {
    public static String repeatDash(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
