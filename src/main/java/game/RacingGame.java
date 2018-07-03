package game;

import common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int tryTime;
    private int maxPosition;
    private List<Car> cars;
    private List<String> winners;

    public static final int MINIMUM = 1;

    public RacingGame(int tryTime, String[] carOwners) {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        maxPosition = 0;
        this.tryTime = tryTime;
        for (int i = 0; i < carOwners.length; i++) {
            cars.add(new Car(carOwners[i]));
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

    public void printTrackResultWithName() {
        for (Car car : cars)
            System.out.println(car.getName() + " : " + Utils.dashString(car.getPosition()));
    }

    public void findWinnerPosition() {
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }
    }


    public void findWinnersName() {
        for (Car car : cars) {
            addWinner(car);
        }
    }

    public void addWinner(Car car) {
        if (car.getPosition() == maxPosition)
            winners.add(car.getName());
    }

    public void printWinners() {
        System.out.print(winners.get(0));

        if (winners.size() > MINIMUM) {
            printDupleWinners();
        }

        System.out.println("가 최종 우승했습니다.");
    }

    public void printDupleWinners() {
        for (int i = 1; i < winners.size(); i++) {
            System.out.print(", " + winners.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.");
        String inputName = scanner.next();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();

        String[] names = inputName.split(",");
        RacingGame racingGame = new RacingGame(tryTime, names);
        racingGame.moveCars();

        System.out.println("실행 결과");
        racingGame.printTrackResultWithName();
        racingGame.findWinnerPosition();
        racingGame.findWinnersName();
        racingGame.printWinners();
    }
}