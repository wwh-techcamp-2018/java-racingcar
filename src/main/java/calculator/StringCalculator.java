package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class StringCalculator {

    private static final Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();

    static {
        operators.put("+", (a, b) -> a + b);
        operators.put("-", (a, b) -> a - b);
        operators.put("*", (a, b) -> a * b);
        operators.put("/", (a, b) -> a / b);
    }

    public int calculate(String operator, Integer number1, Integer number2) {
        BiFunction<Integer, Integer, Integer> operatorFn = operators.get(operator);
        if (operatorFn == null) {
            throw new IllegalArgumentException();
        }
        return operatorFn.apply(number1, number2);
    }

    public int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public boolean isBlank(String value) {
        if (value == null || value.equals("")) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int calAnswer(String value) {
        isBlank(value);

        String[] input = value.split(" ");
        int currentValue = parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            String operator = input[i];
            int anotherValue = parseInt(input[i + 1]);
            currentValue = calculate(operator, currentValue, anotherValue);
        }
        return currentValue;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        StringCalculator sc = new StringCalculator();
        System.out.println(sc.calAnswer(value));
    }
}
