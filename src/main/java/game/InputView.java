package game;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getCarNums() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int getTimes() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
