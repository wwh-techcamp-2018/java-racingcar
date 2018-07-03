package racing;

import java.util.ArrayList;
import java.util.List;

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
        List winner = new ArrayList<Car>();
        int max = getMaxPosition();
        for (Car car : cars) {
            if (car.isMaxPosition(max)) {
                winner.add(new Car(car.getPosition(), car.getName()));
            }
        }
        return winner;
    }

    public String printWinner(List<Car> winner) {
        if (winner.isEmpty())
            throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();

        sb.append(winner.get(0).getName());
        for (int i = 1; i < winner.size(); i++) {
            sb.append(", ");
            sb.append(winner.get(i).getName());
        }
        sb.append("가 최종 우승했습니다.");
        return sb.toString();
    }
}