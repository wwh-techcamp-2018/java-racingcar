package game;

import game.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    public static final int MINIMUM_WINNERS = 1;
    private int maxPosition;
    private StringBuffer resultString;
    private List<String> winMember;

    public Winner() {
        maxPosition = 0;
        resultString = new StringBuffer();
        winMember = new ArrayList<>();
    }

    public int findWinnerPosition(List<Car> cars) {
        for (Car car : cars) {
            maxPosition = car.findBiggerPosition(maxPosition);
        }
        return maxPosition;
    }

    public void findWinnersName(List<Car> cars) {
        for (Car car : cars) {
            addWinner(car);
        }
    }

    public void addWinner(Car car) {
        if (car.isReached(maxPosition))
            winMember.add(car.getName());
    }

    public String winnersToString() {
        resultString.append(winMember.get(0));

        if (winMember.size() > MINIMUM_WINNERS) {
            dupleWinnersToString();
        }

        return resultString.toString();
    }

    public void dupleWinnersToString() {
        for (int i = 1; i < winMember.size(); i++) {
            resultString.append(ResultView.COMMA + winMember.get(i));
        }
    }

}
