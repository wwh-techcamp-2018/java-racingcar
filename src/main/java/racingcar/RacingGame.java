package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final String LOAD = "-";
    private List<Car> cars = new ArrayList<>();
    private int carCount;

    public RacingGame(int carCount) {
        this.carCount = carCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryingCount = scanner.nextInt();

        RacingGame racingGame = new RacingGame(carCount);
        racingGame.createCars();
        racingGame.repeatRace(tryingCount);
        racingGame.printAllCar();
    }

    private void createCars(){
        for (int i = 0; i < this.carCount; i++) {
            this.cars.add(new Car(0));
        }
    }

    private void repeatRace(int tryingCount) {
        for (int i = 0; i < tryingCount; i++) {
            updateAllCar();
        }
    }

    private void updateAllCar() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private static int getRandomNo() {
        return new Random().nextInt(10);
    }

    private void printAllCar() {
        System.out.println("\n실행 결과\n");
        for (Car car : this.cars) {
            println(getRoad(car.getPosition()));
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }

    static String getRoad(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(LOAD);
        }
        return sb.toString();
    }
}
