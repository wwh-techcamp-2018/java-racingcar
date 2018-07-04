package racingcar;

import util.StringUtil;

import java.util.List;
import java.util.Scanner;

public class RacingGameView {
    public static void printWinners(String winnerText) {
        System.out.print(winnerText);
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCarResult(List<Car> cars){
        System.out.println("실행결과");
        cars.stream().forEach(car -> {
            System.out.println(car.getName() + " : " + StringUtil.repeatDash(car.getPosition()));
        });
    }

    public static String[] getNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = StringUtil.parseName(scanner.next());
        return names;
    }

    public static int getTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();
        return time;
    }

}
