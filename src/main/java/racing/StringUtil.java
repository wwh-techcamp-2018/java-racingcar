package racing;

public class StringUtil {
    static String repeat(int position, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}
