package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorUtil {
    public static boolean isCustomSplit(String inputString){
        if (isBlank(inputString))
            return false;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        return m.find();
    }

    public static boolean isBlank(String value) {
        return value == null || value.length() == 0;
    }
}
