package racing.game1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public void total(int time, List<Car> carPosition) {
        for (int i = 0; i < time; i++) {
            updatePosition(carPosition);
        }
    }

    private void updatePosition(List<Car> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            carPosition.get(i).move(RacingGame.random());
        }
    }

    public static String getWinner(List<Car> cars) {
        Winner winner = new Winner();
        for (Car car : cars) {
            winner.changeWinnersStateWithDraw(car);
            winner.changeWinnersStateWithWin(car);
        }

        return winner.getWinners().append("가 최종 우승했습니다.").toString();
    }


    static int random() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
