package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {

    public List<Car> carList;
    private int tryNum;

    public RacingGame(int carNum, int tryNum) {
        carList = new ArrayList<>();
        this.tryNum = tryNum;

        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }
    }

    public void startRace() {
        startRace(carList.size());
    }

    public void startRace(int num) {
        for (Car car : carList) {
            car.race(num);
        }
    }

    public void printRacingGame() {
        for (Car car : carList) {
            System.out.println(car.print());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("차 개수 입력");
        int carNum = scanner.nextInt();
        System.out.println("시도 횟수 입력");
        int tryNum = scanner.nextInt();

        RacingGame raceGame = new RacingGame(carNum, tryNum);
        raceGame.startRace();
        raceGame.printRacingGame();
    }
}