package racingcar;

import racingcar.random.TestRandomGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 자동차 생성
        List<RacingCar> cars = RacingCarsFactory.create(ConsoleInputView.getCarNames());
        RacingGame racingGame = new RacingGame(cars, new TestRandomGenerator());

        // 이동
        racingGame.moveCars(ConsoleInputView.getTryCount());

        // 출력
        ConsoleOutputView.printResult(
                new RacingGameResult(cars,
                        RacingGame.makeWinners(cars)));
    }
}
