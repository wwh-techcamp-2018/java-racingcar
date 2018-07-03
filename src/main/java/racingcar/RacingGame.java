package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static List<RacingCar> cars = new ArrayList<>();

    public RacingGame(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new RacingCar());
        }
    }

    public static void main(String[] args) {
        int carNum = ConsoleInputView.getCarNum();       // 입력
        int tryCount = ConsoleInputView.getTryCount();

        RacingGame game = new RacingGame(carNum);           // 생성

        for (int i = 0; i < carNum; i++) {               // 이동
            game.moveCars(cars.get(i), tryCount);
        }

        for (RacingCar car : cars) {               // 출력
            System.out.println(car.makePositionToString(car.getPosition()));
        }

    }

    public void moveCars(RacingCar car, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            car.move(makeRandomNumber(10));
        }
    }

    public int makeRandomNumber(int limit) {
        Random random = new Random();
        return random.nextInt(limit);
    }

}