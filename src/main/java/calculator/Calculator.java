package calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        if (line == null || line.trim().equals("")) {
            throw new IllegalArgumentException("입력값은 null 또는 빈문자열이면 안됩니다.");
        }

        String[] strs = line.split(" ");

        int result = Integer.parseInt(strs[0]); // 초기값

        for (int i = 1; i < strs.length; i = i + 2) {
            result = calculate(strs, result, i);
        }
        System.out.println(result);
    }

    private static int calculate(String[] strs, int result, int i) {
        if (strs[i].equals("+")) {
            result = add(strs, result, i);
        }
        if (strs[i].equals("-")) result -= Integer.parseInt(strs[i + 1]);
        if (strs[i].equals("*")) result *= Integer.parseInt(strs[i + 1]);
        if (strs[i].equals("/")) result /= Integer.parseInt(strs[i + 1]);
        return result;
    }

    private static int add(String[] strs, int result, int i) {
        return result + Integer.parseInt(strs[i + 1]);
    }


}
