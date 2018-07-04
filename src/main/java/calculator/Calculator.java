package calculator;

import calculator.parser.StringParser;

import java.util.List;

public class Calculator {

    private StringParser parser;

    public Calculator(StringParser parser) {
        this.parser = parser;
    }

    public int calculate(String input) throws IllegalArgumentException {
        List<String> tokens = parser.parse(input);
        List<String> operators = parser.extractOperators(tokens);
        List<Integer> operands = parser.extractOperands(tokens);

        int result = operands.get(0);
        for (int i = 0; i < operators.size(); ++i) {
            String operator = operators.get(i);
            int operand = operands.get(i + 1);
            result = operate(operator, result, operand);
        }

        return result;
    }

    public int operate(String operator, int a, int b) {
        if (operator.equals("+")) return a + b;
        if (operator.equals("-")) return a - b;
        if (operator.equals("/")) return a / b;
        if (operator.equals("*")) return a * b;

        throw new IllegalArgumentException();
    }

}
