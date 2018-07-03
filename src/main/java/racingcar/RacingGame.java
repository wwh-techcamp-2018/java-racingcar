package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_MAX_LIMIT = 10;
    private List<RacingCar> cars = new ArrayList<>();

    public RacingGame(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new RacingCar());
        }
    }

    public static void main(String[] args) {
        int carNum = ConsoleInputView.getCarNum();
        int tryCount = ConsoleInputView.getTryCount();

        RacingGame racingGame = new RacingGame(carNum);

        for (int i = 0; i < carNum; i++) {
            racingGame.moveCars(tryCount);
        }

        for (RacingCar car : racingGame.cars) {
            System.out.println(RacingCar.makePositionToString(car.getPosition()));
        }

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

}