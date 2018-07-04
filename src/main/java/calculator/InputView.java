package calculator;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input = scanner.nextLine();
        int result = StringCalculator.run(input);
        System.out.println(result);
    }
}
