package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.RacingCars;

import java.util.List;

public class ResultView {

    private RacingCars racingCars;

    public ResultView(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void printCarMoves() {
        System.out.println(racingCars);
    }

    public void printWinners() {
        List<Car> winnerCars = racingCars.getWinnerCars();
        System.out.print(getWinnerNames(winnerCars));
        System.out.println("가 최종 우승했습니다.");
    }

    private String getWinnerNames(List<Car> winnerCars) {
        StringBuffer sb = new StringBuffer();
        for (Car car : winnerCars) {
            sb.append(car.getName());
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

}
