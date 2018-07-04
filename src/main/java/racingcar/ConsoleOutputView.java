package racingcar;

import java.util.List;

public class ConsoleOutputView {
    public static void printResult(RacingGameResult racingGameResult) {
        List<RacingCar> cars = racingGameResult.getCars();
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + RacingCar.makePositionToString(car.getPosition()));
        }
        System.out.println(getWinnerNames(racingGameResult.getWinners()));
    }

    public static String getWinnerNames(List<RacingCar> winners) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < winners.size() - 1; i++) {
            sb.append(winners.get(i).getName());
            sb.append(", ");
        }
        sb.append(winners.get(winners.size() - 1).getName());
        sb.append("가 최종 우승했습니다.");
        return sb.toString();
    }
}