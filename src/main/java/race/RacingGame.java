package race;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int LIMIT = 4;

    private int time;
    private List<Car> cars;
    private int maxPosition = 0;

    public RacingGame(String[] carNames, int time) {
        if (carNames.length <= 0 || time <= 0) {
            throw new IllegalArgumentException();
        }

        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        this.time = time;
    }

    public void play() {
        for (int i = 0; i < time; i++) {
            run();
        }
    }

    private void run() {
        for (int i = 0; i < cars.size(); i++) {
            move(i);
            this.maxPosition = Math.max(this.maxPosition, cars.get(i).getPosition());
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

    public List<Car> chooseWinner() {
        return cars.stream()
                .filter((c) -> c.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public static int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        String[] carNames = consoleView.inputCarNames();
        int time = consoleView.inputTime();

        RacingGame racingGame = new RacingGame(carNames, time);

        racingGame.play();

        consoleView.showResult(racingGame.cars);
        consoleView.showWinners(racingGame.chooseWinner());
    }
}
