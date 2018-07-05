package racingcar.main;

import racingcar.domain.InputView;
import racingcar.domain.RacingCarGame;
import racingcar.domain.ResultView;
import racingcar.dto.RacingGameInput;
import racingcar.dto.RacingGameResult;
import racingcar.utils.RandomGenerator;
import racingcar.utils.StaticGenerator;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingGameInput gameInput = InputView.getInput();
        RacingCarGame racingCarGame = new RacingCarGame(gameInput, new RandomGenerator());
        RacingGameResult gameResult = racingCarGame.run(gameInput.getNumTrial());
        ResultView.printResult(gameResult);
    }
}