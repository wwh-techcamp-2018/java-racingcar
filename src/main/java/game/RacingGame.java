package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int tryTime;
    private ArrayList<Car> carArrayList;

    public RacingGame() {
        carArrayList = new ArrayList<>();
    }

    public void initGame(int tryTime, int carNumber) {
        this.tryTime = tryTime;
        for (int i = 0; i < carNumber; i++) {
            carArrayList.add(new Car());
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
        for (Car car : carArrayList) {
            car.movePosition(getRandomValue());
        }
    }

    public void moveCars() {
        for (int i = 0; i < getTryTime(); i++) {
            moveCar();
        }
    }

    public String dashString(int position) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < position; i++) {
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }

    public void printGameResult() {
        for (Car car : carArrayList)
            System.out.println(dashString(car.getPosition()));
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대 수는 얼마인가요?");
        int carNumber = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();

        racingGame.initGame(tryTime, carNumber);
        racingGame.moveCars();

        System.out.println("실행 결과 : ");
        racingGame.printGameResult();
    }
}