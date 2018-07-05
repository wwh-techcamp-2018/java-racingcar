package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.getCarNames();
        int times = inputView.getMoveTimes();

        RacingGame game = new RacingGame(carNames);
        game.run(times);

        RacingCars racingCars = game.getRacingCars();
        ResultView resultView = new ResultView(racingCars);
        resultView.printCarMoves();
        resultView.printWinners(game.getWinners());
    }
}
