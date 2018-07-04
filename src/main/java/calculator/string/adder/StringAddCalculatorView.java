package calculator.string.adder;

import java.util.Scanner;

public class StringAddCalculatorView {
    public static void printResult(int sum) {
        System.out.print("문자열에서 추출한 숫자들의 합은 : " + sum);
    }
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
