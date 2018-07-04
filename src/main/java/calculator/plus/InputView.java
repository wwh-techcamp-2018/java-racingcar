package calculator.plus;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public String getInput() {
        System.out.print("덧셈 할 수식을 입력해주세요: ");
        return scanner.nextLine();
    }
}
