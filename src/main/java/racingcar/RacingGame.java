package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static ArrayList<Car> cars = new ArrayList<>();
    static final String LOAD   = "-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryingCount = scanner.nextInt();

        createCars(carCount);
        repeatRace(tryingCount);
        printAllCar();
    }

    private static void createCars(int carCount){
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
    }

    private static void repeatRace(int tryingCount) {
        for (int i = 0; i < tryingCount; i++) {
            updateAllCar();
        }
    }

    private static void updateAllCar() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private static int getRandomNo() {
        return new Random().nextInt(10);
    }

    private static void printAllCar() {
        System.out.println("\n실행 결과\n");
        for (Car car : cars) {
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
