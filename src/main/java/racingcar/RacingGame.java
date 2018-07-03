package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final int RANDOM_MAX_LIMIT = 10;
    private List<Car> cars = new ArrayList<>();
    private String[] names;

    public RacingGame(String[] names) {
        this.names = names;
        createCars(names);
    }

    public static void main(String[] args) {
        ConsoleInputView inputViewer = new ConsoleInputView();
        String[] names = inputViewer.getCarNames();
        int tryingCount = inputViewer.getTryCount();

        RacingGame racingGame = new RacingGame(names);
        racingGame.repeatRace(tryingCount);

        ConsoleOutputView outputViewer = new ConsoleOutputView();
        outputViewer.printAllCar(racingGame.getCars());
        outputViewer.printWinners(racingGame.getWinners(racingGame.getMax()));
    }

    public List<Car> getCars() {
        return cars;
    }

    private void createCars(String[] names){
        for (String name : names) {
            this.cars.add(new Car(0, name));
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

    private int getMax() {
        int maximum = 0;
        for (int i = 0; i < cars.size(); i++) {
            maximum = Math.max(cars.get(i).getPosition(), maximum);
        }
        return maximum;
    }

    private String getWinners(int max) {
        StringBuilder matchedNames = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            matchedNames.append(getMatchedName(i, max));
        }
        return String.join(", ", matchedNames.toString().split(" "));
    }

    private String getMatchedName(int i, int max) {
        if(cars.get(i).isSame(max)) {
            return cars.get(i).getName() + " ";
        }
        return "";
    }
}
