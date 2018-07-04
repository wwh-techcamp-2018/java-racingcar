package calculator.tdd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {

    Splitter splitter;

    public StringAdder(){

    }

    public int run(String input){

        if(isInvalidate(input)){ // 0, null
            return 0;
        }

        String formatedNumbers = formatNumberStr(input);

        if(splitter.unSupports(formatedNumbers))
            throw new IllegalArgumentException();

        return calculateSum(splitter.split(formatedNumbers));
    }

    private int calculateSum(String[] numbers){
        int result = 0;
        for(String number : numbers){
            result += Integer.parseInt(number);
        }
        return result;


    }

    private boolean isInvalidate(String input){
        if(input == null || input.length() == 0){
            return true;
        }
        return false;
    }
//    public String getSplitter(String input){
//        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
//        if (m.find()) {
//            return m.group(1);
//        }
//        return null;
//    }
    public String formatNumberStr(String input){

            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (m.find()) {
                String splitStr = m.group(1);
                splitter = new CustomSplitter(splitStr);
                return m.group(2);
            }
            splitter = new DefaultSplitter();
            return input;
    }



}
