package racing;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameString = scanner.nextLine();
        System.out.println("시도 횟수 입력");
        int tryNum = scanner.nextInt();

        String[] names = nameString.split(",");
        RacingGame raceGame = new RacingGame(names);

        raceGame.startRace(tryNum);
        System.out.println(raceGame.printRacingGame());
        System.out.println(raceGame.printWinner(raceGame.getWinner()));
    }
}