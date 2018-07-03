package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_MAX_LIMIT = 10;
    private List<RacingCar> cars = new ArrayList<>();

    public RacingGame(String text) {
        String[] carNames = parseTextToCarNames(text);
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new RacingCar(carNames[i]));
        }
    }

    public static void main(String[] args) {
        String names = ConsoleInputView.getCarNames();
        int tryCount = ConsoleInputView.getTryCount();

        RacingGame racingGame = new RacingGame(names);
        racingGame.moveCars(tryCount);

        ConsoleOutputView.printResult(racingGame.getCars(), racingGame.checkWinners());
    }

    public void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCar();
        }
    }

    public void moveCar() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(makeRandomNumber(RANDOM_MAX_LIMIT));
        }
    }

    public static int makeRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

    public List<String> checkWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = cars.get(0).getPosition();
        winners.add(cars.get(0).getName());

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getPosition() > maxPosition) {
                winners.clear();
                winners.add(cars.get(i).getName());
            }
            if (cars.get(i).getPosition() == maxPosition) {
                winners.add(cars.get(i).getName());
            }
        }
        return winners;
    }

    private String[] parseTextToCarNames(String text) {
        return text.split(",");
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}