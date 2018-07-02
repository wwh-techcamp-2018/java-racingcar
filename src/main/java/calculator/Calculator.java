package calculator;

import java.util.Scanner;

public class Calculator {
    private int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        System.out.println(new Calculator().calculate(text));
    }

    public int calculate(String text) {
        String[] values = splitText(text);
        result += toInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            calculate(values[i], toInt(values[i + 1]));
        }

        return result;
    }

    private String[] splitText(String text) {
        if (text == null || "".equals(text)) {
            throw new IllegalArgumentException();
        }

        String[] result = text.split(" ");

        if (result.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    private int toInt(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void calculate(String operator, int number) {
        if ("+".equals(operator)) {
            result += number;
            return;
        }
        if ("-".equals(operator)) {
            result -= number;
            return;
        }
        if ("*".equals(operator)) {
            result *= number;
            return;
        }
        if ("/".equals(operator)) {
            result /= number;
            return;
        }

        throw new IllegalArgumentException();
    }
}
