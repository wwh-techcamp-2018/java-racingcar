package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars = new ArrayList<>();
    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    public RacingGame(int carNumber, int time) {
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        this.time = time;
    }

    public int[] move() {
        for (int i = 0; i < time; i++) {
            moveCars(generateRandomValues(cars.size()));
        }

        return getCarPositions();
    }


    void moveCars(int[] randomValues) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomValues[i]);
        }
    }

    public int[] getCarPositions() {
        int[] result = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            result[i] = cars.get(i).getPosition();
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

