package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int time;
    private List<Car> cars;
    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    public RacingGame(String carNames, int time) {
        if (time <= 0 || carNames == null || "".equals(carNames)) throw new IllegalArgumentException();

        cars = parseCarName(carNames);
        this.time = time;
    }

    private List<Car> parseCarName(String carName) {
        return Arrays.stream(carName.split(",")).map(Car::new).collect(Collectors.toList());
    }

    public List<Car> play() {
        for (int i = 0; i < time; i++) {
            moveCars(generateRandomValues(cars.size()));
        }
        return cars;
    }


    List<Car> moveCars(int[] randomValues) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomValues[i]);
        }
        return cars;
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

    public void showResult() {
        ResultView.showResult(cars);
    }

    public static void main(String[] arr) {
        RacingGame racingGame = new RacingGame(InputView.getCarNames(), InputView.getTime());
        racingGame.play();
        racingGame.showResult();
    }
}

