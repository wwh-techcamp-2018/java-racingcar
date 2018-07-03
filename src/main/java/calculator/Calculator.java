package calculator;

import java.util.*;


public class Calculator {

    int inputData() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int result = calcData(input);
        return result;
    }

    int calcData(String input) {
        String[] values = input.split(" ");
        int result = Integer.parseInt(values[0]);
        String oper = null;

        for (int i = 1; i < values.length; i += 2) {
            oper = values[i];
            result = calc(oper, result, Integer.parseInt(values[i + 1]));
        }
        return result;
    }

    private int calc(String oper, Integer i, Integer j) {
        if (oper.equals("*"))
            return this.multi(i, j);
        if (oper.equals("/"))
            return this.divide(i, j);
        if (oper.equals("+"))
            return this.plus(i, j);
        if (oper.equals("-"))
            return this.minus(i, j);
        return 0;
    }


    public int plus(int i, int j) {
        return i + j;
    }

    public int minus(int i, int j) {
        return i - j;
    }

    public int multi(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        return i / j;
    }
}
