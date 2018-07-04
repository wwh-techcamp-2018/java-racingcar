package racingcar;

import java.util.Scanner;

public class ConsoleInputView {
    private static Scanner sc = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return sc.nextLine();
    }

    public static int getTryCount() {
        System.out.println("시도할 회 수를 입력해주세요");
        return Integer.parseInt(sc.nextLine());
    }
}
