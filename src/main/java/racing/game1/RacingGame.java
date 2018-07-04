package racing.game1;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<Car>();

    public RacingGame(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void total(int time) {
        for (int i = 0; i < time; i++) {
            updatePosition(cars);
        }
    }

    private void updatePosition(List<Car> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            carPosition.get(i).move();
        }
    }

    public static String getWinner(List<Car> cars) {
        return Winner.getWinners(cars, Winner.getMaxPosition(cars));
    }

    public void printResult() {
        ResultView.printResult(this.cars,RacingGame.getWinner(this.cars));
    }
}
