package stringCalculator;

import calculator.Calculator;

public class StringCalculator {

    public int calculate(String input) throws IllegalArgumentException
    {
        String[] tokens = parse(input);

        int result = parseInt(tokens[0]);
        for(int i = 1; i < tokens.length-1; ++i)
        {
            String operator = tokens[i];
            int operand = parseInt(tokens[i+1]);

            result = operate(operator, result, operand);
        }

        return result;
    }

    private int parseInt(String input)
    {
        return Integer.parseInt(input);
    }

    private String[] parse(String input)
    {
        if (null == input) throw new IllegalArgumentException();
        if (input.isEmpty()) throw new IllegalArgumentException();

        String[] tokens = input.split(" ");
        return tokens;
    }

    private int operate(String operator, int a, int b)
    {
        if(operator.equals("+")) return Calculator.plus(a, b);
        if(operator.equals("-")) return Calculator.minus(a, b);
        if(operator.equals("/")) return Calculator.multiply(a, b);
        if(operator.equals("*")) return Calculator.divide(a, b);

        throw new IllegalArgumentException();
    }
}
