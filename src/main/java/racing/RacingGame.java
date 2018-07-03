package racing;

import java.util.ArrayList;
import java.util.Scanner;

public class RacingGame {

    public ArrayList<Car> carList;
    private int carNum;
    private int tryNum;

    public RacingGame() {
        carList = new ArrayList<>();
    }

    public RacingGame(int carNum, int tryNum) {
        carList = new ArrayList<>();
        this.carNum = carNum;
        this.tryNum = tryNum;

        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }
    }

    public void startRace() {
        for (int i = 0; i < carNum; i++) {
            carList.get(i).race(carNum);
        }
    }

    public void startRace(int num) {
        for (int i = 0; i < num; i++) {
            carList.get(i).race(num);
        }
    }

    public void printRacingGame() {
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).print());
        }
    }

    public void setCarNum(int carNum) {
        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }
        this.carNum = carNum;
    }

    public void setTryNum(int tryNum) {
        this.tryNum = tryNum;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTryNum() {
        return tryNum;
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
