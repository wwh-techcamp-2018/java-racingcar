package calculator;

import java.util.Scanner;

public class Calculator {

    public static String[] parse(String text) {
        if (text == null || text == " ") {
            throw new IllegalArgumentException();

        }
        return text.split(" ");
    }

    public static int calculate(String[] arr) {
        int result = Integer.parseInt(arr[0]);

        for(int i=1; i < arr.length; i+=2) {
            int temp = Integer.parseInt(arr[i + 1]);
            result = calculate(result, temp, arr[i]);
        }

        return result;
    }

    private static int calculate(int result, int temp, String operator) {
        if (operator.equals("+")) {
            return result + temp;
        }

        if (operator.equals("-")) {
            return result - temp;
        }

        if (operator.equals("*")) {
            return result * temp;
        }

        if (operator.equals("/")) {
            return result / temp;
        }

        throw new ArithmeticException();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        System.out.println(Calculator.calculate(Calculator.parse(value)));
    }
}
