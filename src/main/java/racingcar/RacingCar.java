package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryingCount = scanner.nextInt();

        Car[] cars = createCars(carCount);
        repeatRace(tryingCount, cars);
        printAllCar(cars);
    }

    private static Car[] createCars(int carCount){
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(0);
        }
        return cars;
    }

    private static void repeatRace(int tryingCount, Car[] cars) {
        for (int i = 0; i < tryingCount; i++) {
            updateAllCar(cars);
        }
    }

    private static void updateAllCar(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            updateCarPosition(cars[i]);
        }
    }

    private static void updateCarPosition(Car car) {
        int newPosition = getNewPosition(car.getPosition(), getRandomNo());
        car.setPosition(newPosition);
    }

    public static int getNewPosition(int position, int randomNo) {
        if (randomNo >= 4)
            return ++position;
        return position;
    }

    private static int getRandomNo() {
        return new Random().nextInt(10);
    }

    private static void printAllCar(Car[] cars) {
        System.out.println("\n실행 결과\n");
        for (int i = 0; i < cars.length; i++) {
            println(getRoad(cars[i].getPosition()));
        }
    }

    private static void println(String message) {
        System.out.println(message);
    }

    public static String getRoad(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
