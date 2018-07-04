package calculator.string.adder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpliterFactory {
    public static Spliter createSpliter(String s){
        Matcher m = Pattern.compile("//(.)N(.*)").matcher(s);
        if (m.find()) {
            return new CustomSpliter(m.group(1));
        }
        return new DefaultSpliter();
    }
}
