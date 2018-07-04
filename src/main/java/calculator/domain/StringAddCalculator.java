package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public boolean isBlank(String s){
        return s.isEmpty();
    }

    public boolean isCustomRegex(String text) {
        return text.contains("//") && text.contains("\n");
    }

    public String[] split(String text, String regex) {
        if(isCustomRegex(regex))
            return customSplit(text);
        return nonCustomSplit(text,regex);
    }

    public int add(String[] stringNumbers) {
        int answer = 0;
        for (int i = 0; i < stringNumbers.length; i++) {
            answer += convertNumber(stringNumbers[i]);
        }
        return answer;
    }

    public String[] nonCustomSplit(String text,String regex) {
        if(isBlank(text))
            return new String[]{"0"};
        return text.split(regex);
    }

    public String[] customSplit(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String[] tokens = new String[]{"0"};
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return tokens;
    }

    public int convertNumber(String text) {
        int number = Integer.parseInt(text);
        if(number < 0) throw new NumberFormatException();
        return number;

    }
}
