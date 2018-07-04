package calculator.tdd;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements Splitter{
    public String regex;

    public CustomSplitter(String singleSplitter){
        if(inValidateSplitter(singleSplitter))
            throw new IllegalArgumentException();
        this.regex = singleSplitter;
    }
    public CustomSplitter(List<String> splitters){
        this.regex = "[" + String.join("", splitters)+"]";
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
