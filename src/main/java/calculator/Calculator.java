package calculator;

public class Calculator {
    int plus(int a, int b) {
        return a + b;
    }

    int minus(int a, int b) {
        return a - b;
    }

    static int parseInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    int calculate(String expression) {
        String[] elements = expression.split(" ");
        int curValue = Calculator.parseInt(elements[0]);

        for(int i = 1; i < elements.length; i += 2) {
            String operator = elements[i];
            int calcValue = Calculator.parseInt(elements[i + 1]);
            curValue = Calculator.operate(curValue, operator, calcValue);
        }

        return curValue;
    }

    static int operate(int curValue, String operator, int calcValue) {

        if(operator.equals("+")) {
            return curValue + calcValue;
        } else if(operator.equals("-")) {
            return curValue - calcValue;
        } else if(operator.equals("*")) {
            return curValue * calcValue;
        } else if(operator.equals("/")) {
            return curValue / calcValue;
        }

        throw new IllegalArgumentException();
    }
}
