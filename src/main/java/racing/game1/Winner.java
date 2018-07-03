package racing.game1;

public class Winner {
    private int highScore = -1;
    private StringBuilder winners = new StringBuilder();


    public StringBuilder getWinners() {
        return winners;
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
