package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputViewer = new InputView();
        String[] names = RacingGame.splitNames(inputViewer.getCarNames());
        int tryingCount = inputViewer.getTryCount();

        RacingGame racingGame = new RacingGame(CarFactory.createCars(names));
        racingGame.race(tryingCount);

        OutputView outputViewer = new OutputView();
        outputViewer.print(racingGame);
    }
}
