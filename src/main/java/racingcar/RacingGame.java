package racingcar;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int[] carPositions;
    private int time;

    public RacingGame(int carNum, int time) {
        carPositions = new int[carNum];
        this.time = time;
    }

    public int[] getCarPositions() {
        return carPositions;
    }

    public int[] move(int randomNo, int index) {
        //forward when more than 4
        if (randomNo >= 4) {
            carPositions[index]++;
        }
        return carPositions;
    }

    public void moveAll() {
        int randomNum = 0;
        for (int j = 0; j < carPositions.length; j++) {
            randomNum = getRandomNo();
            move(randomNum, j);
        }
    }

    public int getRandomNo() {
        Random r = new Random();
        return r.nextInt(10);
    }

    public String repeat(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void printCarResult(int index){
        System.out.println(repeat(carPositions[index]));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        RacingGame racingGame = new RacingGame(carNum, time);
        for (int i = 0; i < time; i++) {
            racingGame.moveAll();
        }

        System.out.println("실행 결과");
        for (int i = 0; i < carNum ; i++) {
            racingGame.printCarResult(i);
        }

    }
}
