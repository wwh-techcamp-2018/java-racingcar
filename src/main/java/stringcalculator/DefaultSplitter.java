package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Character.isDigit;

public class DefaultSplitter implements Splitter {

    String equation;

    public DefaultSplitter(String equation) {
        this.equation = equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    @Override
    public boolean supports() {
        List<Character> characters
                = new ArrayList<>(
                equation.chars()
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
        return c == ',' | c == ':' | isDigit(c);
    }


    @Override
    public String[] split() {
        String[] numbers = equation.split(",|:");
        return numbers;
    }


}
