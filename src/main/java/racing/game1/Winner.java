package racing.game1;

public class Winner {
    private int highScore = -1;
    private StringBuilder winners = new StringBuilder();
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";


    public StringBuilder getWinners() {
        return winners.append(WINNER_MESSAGE);
    }

    public void changeWinnersStateWithWin(Car car) {
        if (car.isWin(highScore)) {
            this.highScore = car.getPosition();
            this.winners = new StringBuilder();
            this.winners.append(car.getName());
        }
    }

    public void changeWinnersStateWithDraw(Car car) {
        if (car.isDraw(highScore)) {
            winners.append(",");
            winners.append(car.getName());
        }
    }
}
