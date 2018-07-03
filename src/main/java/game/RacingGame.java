package game;

import common.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
    private int tryTime;
    private List<Car> cars;

    public RacingGame(int tryTime, String[] carOwners) {
        cars = new ArrayList<>();
        this.tryTime = tryTime;

        for (int i = 0; i < carOwners.length; i++) {
            cars.add(new Car(carOwners[i]));
        }
    }

    public int getTryTime() {
        return tryTime;
    }

    public List<Car> getCars() { return cars; }

    public void moveCar() {
        for (Car car : cars) {
            car.movePosition(Utils.getRandomValue());
        }
    }

    public void moveCars() {
        for (int i = 0; i < getTryTime(); i++) {
            moveCar();
        }
    }

    public List<String> trackResultWithName() {
        List<String> trackResult = new ArrayList<>();
        for (Car car : cars)
            trackResult.add(car.toString());

        return trackResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉽표(,)를 기준으로 구분.");
        String inputName = scanner.next();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();

        String[] names = inputName.split(",");
        RacingGame racingGame = new RacingGame(tryTime, names);
        Winner winners = new Winner();
        List<Car> carList = racingGame.getCars();
        racingGame.moveCars();

        System.out.println("실행 결과");

        Utils.print(racingGame.trackResultWithName());
        winners.findWinnerPosition(carList);
        winners.findWinnersName(carList);
        Utils.print(winners.winnersToString());
    }
}