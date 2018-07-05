package game;

import game.view.InputView;
import game.view.ResultView;

import java.util.List;

public class RacingGameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String inputName = inputView.inputCarName();
        int tryTime = inputView.inputTime();

        RacingGame racingGame = new RacingGame(tryTime, inputName.split(ResultView.COMMA));
        Winner winners = new Winner();
        List<Car> carList = racingGame.getCars();

        racingGame.moveCars();

        winners.findWinnerPosition(carList);
        winners.findWinnersName(carList);

        ResultView.printResult();
        ResultView.print(racingGame.trackResultWithName());
        ResultView.print(winners.winnersToString());

    }

}
