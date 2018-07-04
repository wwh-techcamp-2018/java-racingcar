package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplit extends Split {

    private String splitter;

    public void setSplitter(String splitter){
        this.splitter = splitter;
    }

    @Override
    String getSpliter() {
        return this.splitter;
    }

    @Override
    String[] split(String value) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        m.find();
        setSplitter(m.group(1));
        return splitInternal(m.group(2));
    }
}
