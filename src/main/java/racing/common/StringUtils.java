package racing.common;

public class StringUtils {
    public static String createDash(int num) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < num; i++) {
            st.append("-");
        }
        return st.toString();
    }

    public static String[] tokenizer(String inputName) {
        String[] names = inputName.split(",");
        return names;
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
