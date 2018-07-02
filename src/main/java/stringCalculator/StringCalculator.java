package stringCalculator;

import calculator.Calculator;

import java.util.Stack;

public class StringCalculator {
    int calculate(String s)
    {

        String[] tokens = parse(s);

        Stack<Integer> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        //@todo
        for(int i = 0; i < tokens.length; ++i)
        {
            if ((i % 2) == 0)
                operands.push(Integer.parseInt(tokens[i]));
            else
                operators.push(tokens[i]);
        }

        while(!operators.empty())
        {
            String op = operators.pop();

            Integer a = operands.pop();
            Integer b = operands.pop();

            Integer result = calculate(op, a, b);

            operands.push(result);
        }

        return operands.pop(); // Integer -> int
    }

    boolean isValid(String input)
    {
        if(null == input) return false;
        //@todo
    }

    String[] parse(String s)
    {
        String[] tokens = s.split(" ");
        return tokens;
    }

    Integer calculate(String operator, Integer a, Integer b)
    {
        if(operator.equals("+")) return Calculator.plus(a, b);
        if(operator.equals("-")) return Calculator.minus(a, b);
        if(operator.equals("/")) return Calculator.multiply(a, b);
        if(operator.equals("*")) return Calculator.divide(a, b);
    }
}
