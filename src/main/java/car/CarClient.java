package car;

import car.model.Car;
import car.view.InputUI;
import car.view.ResultUI;

import java.util.ArrayList;
import java.util.List;

public class CarClient {
    private CarRunner<Car> runner;

    public CarClient(int numOfCars) {

        List<Car> cars = new ArrayList<Car>(numOfCars);
        for (int i = 0; i < numOfCars; i++) {
            cars.add(new Car());
        }
        runner = new CarRunner<Car>(cars);

    }

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int numOfCars = inputUI.getNumOfCars();
        int numOfGames = inputUI.getNumOfGames();

        CarClient client = new CarClient(numOfCars);
        client.run(numOfGames);

        ResultUI.printByPositions(client.getPositions());
    }

    public void run(int numOfGames){
        runner.run(numOfGames);
    }

    List<Integer> getPositions() {
        return runner.getPositions();
    }

}
