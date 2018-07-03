package racingcar;

import util.IntegerUtil;
import util.StringUtil;

import java.util.Scanner;

public class RacingGame {
    private Car[] cars;
    private int time;

    public RacingGame(int carNum, int time) {
        cars = new Car[carNum];
        this.time = time;
    }

    public void moveAll() {
        int randomNum = 0;
        for (int i = 0; i < cars.length; i++) {
            randomNum = IntegerUtil.getRandomNo();
            cars[i].move(randomNum);
        }
    }

    public void printCarResult(int index){
        System.out.println(StringUtil.repeatDash(cars[index].getPosition()));
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
