package calculator.common;

public class StringUtils {

    public static boolean notEmptyInput(String text) {
        if(text.isEmpty() || text == null)
            return false;
        return true;
    }

}
