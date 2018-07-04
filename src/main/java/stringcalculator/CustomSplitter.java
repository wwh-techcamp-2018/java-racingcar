package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class CustomSplitter implements Splitter {

    private String equation;

    public CustomSplitter(String equation) {
        this.equation = equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    String getFilteredString() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.equation);
        if (m.find()) {
            return m.group(2);
        }
        return equation;
    }

    String getDelimiter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(this.equation);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    @Override
    public boolean supports() {

        List<Character> characters
                = new ArrayList<>(
                getFilteredString().chars()
                        .mapToObj(e -> (char) e)
                        .collect(Collectors.toList()));

        List<Character> invalidResults = characters.stream()
                .filter(c -> !isValidChar(c))
                .collect(Collectors.toList());

        if(invalidResults.size() > 0) {
            throw new RuntimeException();
        }
        return true;
    }

    boolean isValidChar(char c) {
        return c == getDelimiter().charAt(0) | isDigit(c);
    }


    @Override
    public String[] split() {

        String[] numbers = getFilteredString().split(getDelimiter());
        return numbers;
    }

}
