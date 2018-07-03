package car;

import car.model.Car;
import car.view.InputUI;
import car.view.ResultUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarClient {
    private List<Car> cars;

    public RacingCarClient(int numOfCars) {
        cars = new ArrayList<Car>(numOfCars);
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car());
        }
    }

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int numOfCars = inputUI.getNumOfCars();
        int numOfGames = inputUI.getNumOfGames();

        RacingCarClient client = new RacingCarClient(numOfCars);
        client.run(numOfGames);

        ResultUI.printGame(client.getPositions());
    }

    public void run(int numOfGames) {
        for (int i = 0; i < numOfGames; i++) {
            moveCars();
        }
    }

    void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNum());
        }
    }

    int getRandomNum() {
        return new Random().nextInt(10);
    }

    List<Integer> getPositions() {
        List<Integer> result = new ArrayList<Integer>(cars.size());
        for (Car car : cars) {
            result.add(car.getPosition());
        }
        return result;
    }

}
