package string.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class StringCalculator {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        System.out.print(result(text));
    }

    static int result(String text) {
        String[] rem = checkString(text).split(" ");
        int a = Integer.parseInt(rem[0]);
        int b;
        String con;
        for (int i = 0; i < rem.length - 2; i += 2) {
            con = rem[i + 1];
            b = Integer.parseInt(rem[i + 2]);

            a = calculate(con, a, b);
        }
        return a;
    }

    static String checkString(String text) {
        if (text == null || text.trim().equals("")) {
            throw new IllegalArgumentException();
        }
        return text;
    }


    static int calculate(String con, int a, int b) {
        switch (con) {
            case "+":
                return plus(a, b);
            case "-":
                return minus(a, b);
            case "/":
                return div(a, b);
            case "*":
                return multi(a, b);
        }
        throw new IllegalArgumentException();
    }

    static int plus(int a, int b) {
        return a + b;
    }

    static int minus(int a, int b) {
        return a - b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    static int multi(int a, int b) {
        return a * b;
    }
}
