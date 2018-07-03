package racingcar;


import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();

    public RacingCarGame(int numCar) {
        for (int i = 0; i < numCar; i++) {
            cars.add(new Car());
        }
    }

    private void tryMove(Car car, int numTrial) {
        Random random = new Random();
        for (int i = 0; i < numTrial; i++) {
            car.move(random.nextInt(10));
        }
    }

    public void run(int numTrial) {
        for (Car car : cars) {
            this.tryMove(car, numTrial);
        }
    }

    public void printCarState() {
        for (Car car : cars) {
            System.out.println(Car.repeat(car.getPosition()));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingCarGame game;
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numCar = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numTrial = scanner.nextInt();

        game = new RacingCarGame(numCar);
        game.run(numTrial);
        game.printCarState();
    }

}
