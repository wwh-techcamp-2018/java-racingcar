package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public List<Car> cars;

    public RacingGame(String[] carName) {
        cars = new ArrayList<>();

        for (int i = 0; i < carName.length; i++) {
            cars.add(new Car(carName[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void startRace(int num) {
        for (Car car : cars) {
            car.race(num);
        }
    }

    public String printRacingGame() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(car.print());
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.comparePosition(maxPosition);
        }
        return maxPosition;
    }

    public List getWinner() {
        int max = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isMaxPosition(max))
                .collect(Collectors.toList());
    }

    public String printWinner(List<Car> winner) {
        if (winner.isEmpty())
            throw new IllegalArgumentException();

        String message = winner.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));

        return message + "가 최종 우승했습니다.";
    }
}