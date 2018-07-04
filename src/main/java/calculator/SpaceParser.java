package calculator;

import calculator.parser.StringParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceParser implements StringParser {

    @Override
    public List<String> parse(String input) {
        if (null == input) throw new IllegalArgumentException();
        if (input.isEmpty()) throw new IllegalArgumentException();

        return Arrays.asList(input.split(" "));
    }

    @Override
    public List<String> extractOperators(List<String> tokens) {
        List<String> operators = new ArrayList<>();
        for (int i = 1; i < tokens.size(); i += 2) {
            operators.add(tokens.get(i));
        }
        return operators;
    }

    @Override
    public List<Integer> extractOperands(List<String> tokens) {
        List<Integer> operands = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i += 2) {
            operands.add(Integer.parseInt(tokens.get(i)));
        }
        return operands;
    }
}
