package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line == null || "".equals(line.trim())) {
            throw new IllegalArgumentException("입력값은 null 또는 빈문자열이면 안됩니다.");
        }

        String[] strs = line.split(" ");
        int result = Integer.parseInt(strs[0]); // 초기값


        for (int i = 1; i < strs.length; i = i + 2) {
            result = calculate(result, strs[i], Integer.parseInt(strs[i + 1]));
        }
        System.out.println(result);

    }

    public static int calculate(int result, String operator, int num) {
        if ("+".equals(operator)) {
            result = add(result, num);
        }
        if ("-".equals(operator)) {
            result = minus(result, num);
        }
        if ("*".equals(operator)) {
            result = multiply(result, num);
        }
        if ("/".equals(operator)) {
            result = divide(result, num);
        }
        return result;
    }


    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return num1 / num2;
    }
}
