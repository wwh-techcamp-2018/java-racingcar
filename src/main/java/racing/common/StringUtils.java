package racing.common;

public class StringUtils {
    public static String createDash(int num) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < num; i++) {
            st.append("-");
        }
        return st.toString();
    }
}
