package racing.game1;

public class Winner {
    private int highScore = -1;
    private StringBuilder winners = new StringBuilder();


    public StringBuilder getWinners() {
        return winners;
    }

    public void isWin(Car car) {
        if (car.getPosition() > highScore) {
            this.highScore = car.getPosition();
            this.winners = new StringBuilder();
            this.winners.append(car.getName());
        }
    }

    public void isDraw(Car car) {
        if (car.getPosition() == highScore) {
            winners.append(",");
            winners.append(car.getName());
        }
    }
}
