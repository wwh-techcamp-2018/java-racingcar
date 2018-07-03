package racing;

public class Racing {

    public static void main(String[] args) {
        RacingController racing = new RacingController(new RacingView());

        racing.setCars();
        racing.setTryCount();
        racing.startGame();
        racing.printResults();
        racing.printWinners();
    }
}
