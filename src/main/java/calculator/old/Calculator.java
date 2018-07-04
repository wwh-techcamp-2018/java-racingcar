package calculator.old;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int calculate(String inputString) {
        String[] splitted = inputString.split(" ");
        if (splitted.length < 3) {
            throw new IllegalArgumentException();
        }

        int tempInt = 0;
        for (int i = 0; i < splitted.length - 2; i += 2) {
            tempInt = multiplexCalc(splitted, i);
            splitted[i + 2] = Integer.toString(tempInt);
        }

        return tempInt;
    }

    private int multiplexCalc(String[] splitted, int i) {
        switch (splitted[i + 1].charAt(0)) {
            case '+':
                return plus(Integer.parseInt(splitted[i]), Integer.parseInt(splitted[i + 2]));
            case '-':
                return minus(Integer.parseInt(splitted[i]), Integer.parseInt(splitted[i + 2]));
            case '*':
                return multiply(Integer.parseInt(splitted[i]), Integer.parseInt(splitted[i + 2]));
            case '/':
                return divide(Integer.parseInt(splitted[i]), Integer.parseInt(splitted[i + 2]));
            default:
                throw new IllegalArgumentException();
        }
    }
}
