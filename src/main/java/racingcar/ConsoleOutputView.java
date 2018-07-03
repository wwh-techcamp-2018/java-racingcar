package racingcar;

import java.util.List;

public class ConsoleOutputView {
    public void printAllCar(List<Car> cars) {
        System.out.println("\n실행 결과\n");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getRoad());
        }
    }

    public void printWinners(String winners) {
        System.out.println("\n" + winners + "가 최종 우승했습니다!");
    }
}
