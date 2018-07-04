package racing.model;

import racing.common.StringUtils;

import java.util.List;

public class GameResult {
    StringBuilder sb;

    public GameResult() {
        sb = new StringBuilder();
    }

    public String printResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i).getName());
            sb.append(" : ");
            sb.append(StringUtils.createDash(cars.get(i).getDistance()));
            sb.append("\n");
        }

        return sb.toString();
    }

    public String printWinner(List<Car> winnerCars) {
        for (int i = 0; i < winnerCars.size() - 1; i++) {
            sb.append(winnerCars.get(i).getName());
            sb.append(",");
        }
        sb.append(winnerCars.get(winnerCars.size()-1).getName());
        sb.append("가 최종 우승했습니다.");
        return sb.toString();
    }

    public String printMessage() {
        return sb.toString();
    }
}
