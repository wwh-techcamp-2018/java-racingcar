package racingcar;

import static racingcar.RacingGameView.getNames;
import static racingcar.RacingGameView.getTime;

public class RacingGameMain {
    public static void main(String[] args) {
        String[] names = getNames();
        int time = getTime();

        RacingGame racingGame = new RacingGame(names);
        for (int i = 0; i < time; i++) {
            racingGame.moveAll();
        }
        racingGame.printResult();
    }
}
