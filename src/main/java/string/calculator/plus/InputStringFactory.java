package string.calculator.plus;

public class InputStringFactory {
    public static boolean isCustomIterator(String text) {
        if (text.charAt(0) == '/') {
            return true;
        }
        return false;
    }

    public static String[] getCustomIterator(String text) {
        String[] str = text.split("//|\n");
        return str;
    }
}
