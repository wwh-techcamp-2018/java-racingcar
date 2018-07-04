package game;

public class PlayGame {
    public static void main(String[] args) {

        InputView iv = new InputView();
        ResultView rv = new ResultView();

        RacingGame game = new RacingGame(iv.getNames());
        game.startGame(iv.getTimes());

        rv.printResult(game);
    }
}
