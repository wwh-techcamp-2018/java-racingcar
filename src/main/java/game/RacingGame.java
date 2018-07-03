package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int RANDOM_BOUND = 10;
    private List<RacingCar> cars = new ArrayList<>();

    RacingGame(int carNum) {
        for (int i = 0; i < carNum; i++)
            cars.add(new RacingCar());
    }

    void startGame(int time) {
        for (int i = 0; i < time; i++)
            rollDice();
    }

    int getRandomNum() {
        return new Random().nextInt(RANDOM_BOUND);
    }

    void rollDice() {
        for (RacingCar car : cars)
            car.moveForward(getRandomNum());
    }

    public List<RacingCar> getCars() {
        return cars;
    }


}