package calculator;

import java.util.Scanner;

public class Calculator {
    private int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
    }

    int calculate(String text) {
        String[] values = text.split(" ");
        result += Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i += 2) {
            parse(values[i], values[i + 1]);
        }

        return result;
    }

    private void parse(String operator, String numberStr) {
        if ("+".equals(operator)) {
            add(numberStr);
            return;
        }
        if ("-".equals(operator)) {
            minus(numberStr);
            return;
        }
        if ("*".equals(operator)) {
            multiply(numberStr);
            return;
        }
        if ("/".equals(operator)) {
            divide(numberStr);
            return;
        }

        throw new IllegalArgumentException();
    }


    private void add(String numberStr) {
        result += Integer.parseInt(numberStr);
    }

    private void minus(String numberStr) {
        result -= Integer.parseInt(numberStr);
    }

    private void multiply(String numberStr) {
        result *= Integer.parseInt(numberStr);
    }

    private void divide(String numberStr) {
        result /= Integer.parseInt(numberStr);
    }
}
