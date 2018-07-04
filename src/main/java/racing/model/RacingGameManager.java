package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameManager {
    private List<Car> cars;
    private ValueGenerator valueGenerator;

    public RacingGameManager(String[] names, ValueGenerator valueGenerator) {
        cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        this.valueGenerator = valueGenerator;
    }

    public RacingGameManager(List<Car> cars) {
        this.cars = cars;
    }

    private int moveCar(int count, Car car) {
        for (int i = 0; i < count; i++) {
            car.move(valueGenerator.generate());
        }
        return car.getDistance();
    }

    void moveCars(int count) {
        for (Car car : cars) {
            moveCar(count, car);
        }
    }

    void sort() {
        Collections.sort(cars);
    }


    boolean judgeWinner(Car car, int max) {
        if (car.hasSameDistance(max)) {
            return true;
        }
        return false;
    }

    private void addWinner(List<Car> winnerCars, Car car) {
        int max = cars.get(0).getDistance();
        if(judgeWinner(car, max)) {
            winnerCars.add(car);
        }
    }

    public List<Car> addWinners(GameResult result) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            addWinner(winnerCars, car);
        }

        return winnerCars;
    }

    public String runGame(int count) {
        GameResult gameResult = new GameResult();
        moveCars(count);
        gameResult.printResult(cars);
        sort();
        gameResult.printWinner(addWinners(gameResult));
        return gameResult.printMessage();
    }

}
