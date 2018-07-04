package racingcar.controller;

import racingcar.controller.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        InputView inputViewer = new InputView();
        int tryingCount = inputViewer.getTryCount();
        String[] names = RacingGame.splitNames(inputViewer.getCarNames());

        CarFactory.createCars(names);




        OutputView outputViewer = new OutputView();
        outputViewer.print(racingGame);
    }
}
