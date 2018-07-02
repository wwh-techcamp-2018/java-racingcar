package calculator;


import java.util.Scanner;

public class Calculator {
    static int plus(int i, int j) {
        return i + j;
    }

    static int minus(int i, int j) {
        return i - j;
    }

    static int multiply(int i, int j) {
        return i * j;
    }

    static int divide(int i, int j) {
        return i / j;
    }

    static int operate(String op, int num1, int num2) {
        int res = 0;

        if(op.equals("+")) {
            res = plus(num1, num2);
        }
        if(op.equals("-")) {
            res = minus(num1, num2);
        }
        if(op.equals("*")) {
            res = multiply(num1, num2);
        }
        if(op.equals("/")) {
            res = divide(num1, num2);
        }

        return res;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int number = Integer.parseInt(values[0]);
        int res = number;
        String op;
        for (int i = 1; i < values.length; i = i + 2) {
            op = values[i];
            number = Integer.parseInt(values[i + 1]);
            res = operate(op, res,  number);
        }

        System.out.println(res);
    }

}
