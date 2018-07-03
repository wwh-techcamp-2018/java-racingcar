package calculator;

import java.util.List;

public class Calculator {

    public int calculate(String input) throws IllegalArgumentException {
        StringParser parser = new StringParser(input);

        List<String> operators = parser.getOperators();
        List<Integer> operands = parser.getOperands();

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
