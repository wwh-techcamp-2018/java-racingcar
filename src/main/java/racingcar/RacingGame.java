package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final String LOAD = "-";
    static final int RANDOM_MAX_LIMIT = 10;
    private List<Car> cars = new ArrayList<>();
    private int carCount;

    public RacingGame(int carCount) {
        this.carCount = carCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = scanner.nextLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryingCount = scanner.nextInt();

        RacingGame racingGame = new RacingGame(names.length);
        racingGame.createCars(names);
        racingGame.repeatRace(tryingCount);
        racingGame.printAllCar();
        racingGame.printWinners();
    }

    private void createCars(String[] names){
        for (String name : names) {
            this.cars.add(new Car(0, name));
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
        return new Random().nextInt(RANDOM_MAX_LIMIT);
    }

    private void printAllCar() {
        System.out.println("\n실행 결과\n");
        for (Car car : this.cars) {
            println(car.getName() + " : " + getRoad(car.getPosition()));
        }
    }

    private void printWinners() {
        System.out.println("\n" + getWinners(getMax()) + "가 최종 우승했습니다!");
    }

    private static void println(String message) {
        System.out.println(message);
    }

    private int getMax() {
        int maximum = 0;
        for (int i = 0; i < cars.size(); i++) {
            maximum = RacingGame.max(cars.get(i).getPosition(), maximum);
        }
        return maximum;
    }

    public static int max(int num1, int num2) {
        return (num1 > num2 ? num1 : num2);
    }

    private String getWinners(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            sb.append(getMatchedName(i, max));
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    private String getMatchedName(int i, int max) {
        if(cars.get(i).getPosition() == max) {
            return cars.get(i).getName() + ", ";
        }
        return "";
    }


    static String getRoad(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(LOAD);
        }
        return sb.toString();
    }
}
