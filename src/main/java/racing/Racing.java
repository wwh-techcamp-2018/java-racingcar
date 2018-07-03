package racing;

import java.util.ArrayList;
import java.util.Scanner;

public class Racing {
    private static final char DASH = '-';

    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        ArrayList<Car> cars = makeCar(carNum);
        for (int i = 0; i < count; i++) {
            drive(cars);
        }
        printPosition(cars);
    }

    private ArrayList<Car> makeCar(int carNum) {
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    private void drive(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.run();
        }
    }

    private void printPosition(ArrayList<Car> cars) {
        for (Car car : cars) {
            System.out.println(buildDash(car.getPosition()));
        }
    }

    static String buildDash(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(DASH);
        }
        return builder.toString();
    }
}
