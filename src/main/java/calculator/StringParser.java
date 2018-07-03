package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private String[] tokens;

    public StringParser(String input) {
        if (null == input) throw new IllegalArgumentException();
        if (input.isEmpty()) throw new IllegalArgumentException();

        this.tokens = input.split(" ");
    }

    public int toInt(String input) {
        return Integer.parseInt(input);
    }

    public List<String> getOperators() {
        List<String> operators = new ArrayList<>();
        for (int i = 1; i < tokens.length; i += 2) {
            operators.add(tokens[i]);
        }
        return operators;
    }

    public List<Integer> getOperands() {
        List<Integer> operands = new ArrayList<>();
        for (int i = 0; i < tokens.length; i += 2) {
            operands.add(toInt(tokens[i]));
        }
        return operands;
    }

}
