package calculator;

import java.util.Scanner;

public class Calculator {
    static int plus(int i, int j) {
        return i + j;
    }

    static int minus(int i, int j) {
        return i - j;
    }

    static int muliple(int i, int j) {
        return i * j;
    }

    static int divide(int i, int j) {
        return i / j;
    }
    
    static int parseResult(String text) {
        if(text == null || text.equals(""))
            throw new IllegalArgumentException();

        String[] values = text.split(" ");
        int number = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            number = calculate(number, values[i], Integer.parseInt(values[i + 1]));
        }

        return number;
    }

    static int calculate(int preNum, String operator, int nextNum) {
        if(operator.equals("+"))
            return plus(preNum, nextNum);
        if(operator.equals("-"))
            return minus(preNum, nextNum);
        if(operator.equals("*"))
            return muliple(preNum, nextNum);

        return divide(preNum, nextNum);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.print(parseResult(input));
    }
}
