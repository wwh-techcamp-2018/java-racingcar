package racing;

import java.util.List;

public class ResultView {

    private static final String CAR_CHARACTER = "-";

    static void showResult(List<Car> cars) {
        System.out.println("실행 결과\n");
        for (Car car : cars) {
            car.printState(CAR_CHARACTER);
        }

        String[] winners = judgeWinners(cars);

        for (int i = 0; i < winners.length - 1; i++) {
            System.out.print(winners[i] + ", ");
        }

        System.out.println(winners[winners.length - 1] + "가 최종 우승했습니다.");
    }

    static String[] judgeWinners(List<Car> cars) {
        int maximumPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
        return cars.stream().filter(car -> car.isMaxPosition(maximumPosition)).map(Car::getName).toArray(String[]::new);
    }
}
