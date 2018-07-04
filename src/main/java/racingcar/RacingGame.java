package racingcar;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int RANDOM_MAX_LIMIT = 10;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] names) {
        createCars(names);
    }

    public static void main(String[] args) {
//        InputView inputViewer = new InputView();
//        String[] names = inputViewer.getCarNames();
//        int tryingCount = inputViewer.getTryCount();
//
//        RacingGame racingGame = new RacingGame(names);
//        racingGame.repeatRace(tryingCount);
//
//        OutputView outputViewer = new OutputView();
//        outputViewer.print(racingGame);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void createCars(String[] names){
        for (String name : names) {
            this.cars.add(new Car(name, 0));
        }
    }

    private void repeatRace(int tryingCount) {
        for (int i = 0; i < tryingCount; i++) {
            updateAllCar();
        }
    }

    private void updateAllCar() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private static int getRandomNo() {
        return new Random().nextInt(RANDOM_MAX_LIMIT);
    }

    public int getMax() {
        int maximum = 0;
        for (Car car : cars) {
            maximum = Math.max(car.getPosition(), maximum);
        }
        return maximum;
    }

    public String getWinners(int max) {
        StringBuilder matchedNames = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            matchedNames.append(getMatchedName(i, max));
        }
        return String.join(", ", matchedNames.toString().split(" "));
    }

    String getMatchedName(int i, int max) {
        if(cars.get(i).isSame(max)) {
            return cars.get(i).getName() + " ";
        }
        return "";
    }
}
