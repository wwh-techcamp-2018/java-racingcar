package calculator;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final List<String> operator = Arrays.asList("+", "-", "*", "/");
    public String[] getInput(String input) {
        if (input.equals("") || input == null) {
            throw new IllegalArgumentException();
        }
        return input.split(" ");
    }
    public int calculate(String[] strings) {
        String currentOperator = null;
        for(String str : strings) {
            if(operator.contains(str)) {
                currentOperator = str;
            }
            int num = Integer.parseInt(str);
            if(currentOperator != null) {

            }
        }
    }
    public int getCalcaulte(String operator, int a, int b) {
        Calculator calculator = new Calculator();
        if(operator.equals("+")) {
            return calculator.plus(a, b);
        }
        if(operator.equals("-")) {
            return calculator.minus(a, b);
        }
        if(operator.equals("*")) {
            return calculator.multiply(a, b);
        }
        return calculator.divide(a, b);

    }
}
