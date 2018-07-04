package calculator.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultSplitter implements Splitter {
    private String regex;

    public DefaultSplitter(){
        this.regex = "[,:]";
    }
    @Override
    public boolean unSupports(String input) {
        return !Pattern.compile("^[0-9]+(" + regex + "[0-9]+)*$").matcher(input).find();
    }

    @Override
    public String[] split(String input) {
        return input.split(regex);
    }

    private boolean inValidateSplitter(String splitter){
        Matcher matcher = Pattern.compile("[0-9]").matcher(splitter);
        return matcher.find();
    }
}
