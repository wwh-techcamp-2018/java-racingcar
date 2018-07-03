package racing;

import java.util.Scanner;

public class InputView {
    public static int getCarNumber() {
        return getInt("자동차 대수는 몇 대 인가요?");
    }

    public static int getTime() {
        return getInt("시도할 횟수는 몇 회 인가요?");
    }

    private static int getInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
}
