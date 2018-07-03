package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String CAR_CHARACTER = "-";
    private int time;
    private List<Car> cars;
    private RandomValueGenerator valueGenerator = new RandomValueGenerator();
    private String[] winners;

    public RacingGame(String carNames, int time) {
        if (time <= 0 || carNames == null || "".equals(carNames)) throw new IllegalArgumentException();

        cars = parseCarName(carNames);
        this.time = time;
    }

    private List<Car> parseCarName(String carName) {
        return Arrays.stream(carName.split(",")).map(Car::new).collect(Collectors.toList());
    }

    public int[] move() {
        for (int i = 0; i < time; i++) {
            moveCars(generateRandomValues(cars.size()));
        }
        return getCarPositions();
    }

    public String[] judgeWinners() {
        int maximumPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(-1);

        winners = cars.stream().filter(car -> car.getPosition() == maximumPosition).map(Car::getName).toArray(String[]::new);
        return winners;
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

    private void showResult() {
        System.out.println("실행 결과\n");
        for (Car car : cars) {
            System.out.printf("%s\t%s\n", car.getName(), generatePositionString(car.getPosition()));
        }

        for (int i = 0; i < winners.length - 1; i++) {
            System.out.print(winners[i] + ", ");
        }

        System.out.println(winners[winners.length - 1] + "가 최종 우승했습니다.");
    }


    static String generatePositionString(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(CAR_CHARACTER);
        }
        return builder.toString();
    }

    public static void main(String[] arr) {
        RacingGame racingGame = new RacingGame(InputView.getCarNames(), InputView.getTime());
        racingGame.move();
        racingGame.judgeWinners();
        racingGame.showResult();
    }
}

