package race;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int LIMIT = 4;

    private List<Car> cars;

    public RacingGame(String[] carNames) {
        if (carNames.length <= 0) {
            throw new IllegalArgumentException();
        }

        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play(int time) {
        for (int i = 0; i < time; i++) {
            run();
        }
    }

    private void run() {
        for (int i = 0; i < cars.size(); i++) {
            move(i);
        }
    }

    public void move(int index) {
        move(index, getRandomNumber());
    }

    public List<Car> move(int index, int randomNumber) {
        if (randomNumber >= LIMIT) {
            cars.get(index).moveFront();
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static List<Car> chooseWinners(List<Car> cars) {
        Car winner = chooseWinner(cars);

        return cars.stream()
                .filter((c) -> c.isOnPosition(winner))
                .collect(Collectors.toList());
    }

    static Car chooseWinner(List<Car> cars) {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = winner.getWinner(car);
        }
        return winner;
    }

    public static int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        String[] carNames = consoleView.inputCarNames();
        int time = consoleView.inputTime();

        RacingGame racingGame = new RacingGame(carNames);

        racingGame.play(time);

        consoleView.showResult(racingGame);
    }
}
