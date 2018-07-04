package racingcar.view;

import racingcar.controller.RacingGame;
import racingcar.model.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private void printAllCar(List<Car> cars) {
        System.out.println("\n실행 결과\n");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getRoad());
        }
    }

    private void printWinners(List<Car> winners) {
        String[] winnerString = new String[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            winnerString[i] = winners.get(i).getName();
        }
        System.out.println("\n" + String.join(",", winnerString) + "가 최종 우승했습니다!");
    }

    public void print(RacingGame racingGame) {
        printAllCar(racingGame.getCars());
        printWinners(racingGame.getWinners());
    }
}
