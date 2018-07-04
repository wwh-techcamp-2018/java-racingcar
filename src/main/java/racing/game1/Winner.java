package racing.game1;

import java.util.List;

public class Winner {

    public static int getMaxPosition(List<Car> cars){
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    public static String getWinners(List<Car> cars, int maxPosition){
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if(car.isWinner(maxPosition)){
                car.appendWinner(winners);
            }
        }
        return winners.toString();
    }
}
