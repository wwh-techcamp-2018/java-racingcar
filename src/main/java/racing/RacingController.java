package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private List<Car> carList = new ArrayList<>();
    private int tryCount = RacingConst.UNDEFINED;
    private RacingView view;

    public RacingController(RacingView view) {
        this.view = view;
    }

    public void setCars() {
        String inputString = view.getInputString(RacingConst.CAR_NAME_QUESTION);
        String[] carNames = RacingUtil.parseCarNames(inputString);

        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }

    public void setTryCount() {
        tryCount = view.getInputInteger(RacingConst.TRY_COUNT_QUESTION);
    }

    public void startGame() {
        if (tryCount == RacingConst.UNDEFINED)
            throw new IllegalStateException();

        for (int i = 0; i < tryCount; i++) {
            startCarRun();
        }
    }

    private void startCarRun() {
        for (Car car : carList) {
            car.run();
        }
    }

    public void printResults() {
        for (Car car : carList) {
            view.printCarResult(car);
        }
    }

    public void printWinners() {
        int maxPosition = RacingUtil.getMaxPosition(carList);
        for (Car car : carList) {
            view.printWinner(car, maxPosition);
        }
        view.printWinnerPostfix();
    }
}
