package racing;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름을 쉼표(,)로 구분).");
        return scanner.nextLine();
    }

    public static int getTime() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextInt();
    }
}
