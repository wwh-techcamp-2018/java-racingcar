package racingcar;

import racingcar.domain.RacingGame;
import racingcar.dto.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame game = new RacingGame(inputView.getCarNames());
        game.run(inputView.getMoveTimes());

        ResultView resultView = new ResultView(game.getRacingCars());
        resultView.printCarMoves();
        resultView.printWinners();
    }
}
