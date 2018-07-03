package game;

import common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int tryTime;
    private List<Car> cars;


    public RacingGame(int tryTime, int carNumber) {
        cars = new ArrayList<>();
        this.tryTime = tryTime;
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
    }

    int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    int getTryTime() {
        return tryTime;
    }

    void moveCar() {
        for (Car car : cars) {
            car.movePosition(getRandomValue());
        }
    }

    public void moveCars() {
        for (int i = 0; i < getTryTime(); i++) {
            moveCar();
        }
    }

    public void printGameResult() {
        for (Car car : cars)
            System.out.println(Utils.dashString(car.getPosition()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대 수는 얼마인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();

        RacingGame racingGame = new RacingGame(tryTime, carNumber);
        racingGame.moveCars();

        System.out.println("실행 결과 : ");
        racingGame.printGameResult();
    }
}