package race;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private int time;
    private List<Car> cars;
    private static final int LIMIT = 4;
    private static final String CAR_TILE = "-";

    public RacingGame(int numOfCars, int time) {
        if (numOfCars <= 0 || time <= 0) {
            throw new IllegalArgumentException();
        }

        cars = Stream.generate(Car::new)
                .limit(numOfCars)
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

    public void print() {
        for (Car car : cars) {
            System.out.println(repeat(car.getPosition()));
        }
    }

    static String repeat(int carPosition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            sb.append(CAR_TILE);
        }

        return sb.toString();
    }

    public static int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int numOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame racingGame = new RacingGame(numOfCars, time);

        racingGame.play();

        System.out.println("실행 결과\n");
        racingGame.print();
    }
}
