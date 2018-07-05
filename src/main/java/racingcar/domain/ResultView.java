package racingcar.domain;

import racingcar.dto.Entry;
import racingcar.dto.RacingGameResult;

import java.util.List;

public class ResultView {
    static final String MOVE_MARKER = "-";

    public static void printResult(RacingGameResult racingGameResult) {
        printEntry(racingGameResult.getEntry());
        printWinner(racingGameResult.getWinners());
    }

    public static String getMoveMarker(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(MOVE_MARKER);
        }
        return sb.toString();
    }

    public static void printEntry(Entry entry) {
        List<Car> cars = entry.getEntry();
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + getMoveMarker(car.getPosition()));
        }
    }

    public static void printWinner(Entry winners) {
        List<Car> cars = winners.getEntry();
        for (int i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getName() + ", ");
        }
        System.out.print(cars.get(cars.size() - 1).getName() + "이(가) 우승했습니다.");
    }
}
