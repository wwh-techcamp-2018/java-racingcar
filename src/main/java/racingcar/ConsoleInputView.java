package racingcar;

import java.util.Scanner;

public class ConsoleInputView {
    private static Scanner sc = new Scanner(System.in);

    public static int getCarNum() {
        System.out.println("자동차 대 수를 입력해주세요");
        return sc.nextInt();
    }

    public static int getTryCount() {
        System.out.println("시도할 회 수를 입력해주세요");
        return sc.nextInt();
    }
}
