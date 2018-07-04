package calculator.plus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private List<Integer> operands = new ArrayList<>();

    public Calculator(String expression) {
        if (!expression.isEmpty())
            operands = parse(expression);
    }

    public int getOperandsSize() {
        return operands.size();
    }

    public static List<Integer> parse(String expression) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);
        if (m.find()) {
            return getOperands(m.group(2).split(m.group(1)));
        }
        return getOperands(expression.split(",|:"));
    }

    private static List<Integer> getOperands(String[] tokens) {
        validateToken(tokens);
        return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateToken(String[] tokens) {
        for (String token : tokens) {
            validateCharacter(token);
            validateNegative(token);
        }
    }

    private static void validateCharacter(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static void validateNegative(String token) {
        if (Integer.parseInt(token) < 0) throw new RuntimeException();
    }

    public int calculate() {
        return operands.stream().mapToInt(Integer::intValue).sum();
    }
}
