package racingcar.view;

import racingcar.RacingGame;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private void printAllCar(List<Car> cars) {
        System.out.println("\n실행 결과\n");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getRoad());
        }
    }

    private void printWinners(String winners) {
        System.out.println("\n" + winners + "가 최종 우승했습니다!");
    }

    public void print(RacingGame racingGame) {
        printAllCar(racingGame.getCars());
        printWinners(racingGame.getWinners(racingGame.getMax()));
    }
}
