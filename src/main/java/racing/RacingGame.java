package racing;

import java.util.Random;

public class RacingGame {
    private int time;
    private Car[] cars;
    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    public RacingGame(int carNumber, int time) {
        this.cars = new Car[carNumber];
        for (int i = 0; i < carNumber; i++) {
            cars[i] = new Car();
        }
        this.time = time;
    }

    public int[] move() {
        for (int i = 0; i < time; i++) {
            moveCars(generateRandomValues(cars.length));
        }

        return getCarPositions();
    }


    void moveCars(int[] randomValues) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].move(randomValues[i]);
        }
    }

    public int[] getCarPositions() {
        int[] result = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            result[i] = cars[i].getPosition();
        }
        return result;
    }

    private int[] generateRandomValues(int size) {
        int[] randomValues = new int[size];
        for (int i = 0; i < size; i++) {
            randomValues[i] = valueGenerator.getRandomValue();
        }
        return randomValues;
    }

    public void setValueGenerator(RandomValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    public static void main(String[] arr) {
        RacingGame racingGame = new RacingGame(InputView.getCarNumber(), InputView.getTime());
        racingGame.move();
        ResultView.showResult(racingGame.getCarPositions());
    }
}

