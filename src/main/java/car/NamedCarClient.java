package car;

import car.domain.CarDTO;
import car.model.Car;
import car.model.NamedCar;
import car.view.InputUI;
import car.view.ResultUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NamedCarClient {
    List<NamedCar> cars;

    public NamedCarClient(List<String> carList) {
        cars = new ArrayList<NamedCar>(carList.size());
        for (String name : carList) {
            cars.add(new NamedCar(name));
        }
    }

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        List<String> carNames = inputUI.getCarNames();
        int numOfGames = inputUI.getNumOfGames();

        runGame(carNames, numOfGames);
    }

    static void runGame(List<String> carNames, int numOfGames) {
        NamedCarClient namedCarClient = new NamedCarClient(carNames);
        namedCarClient.run(numOfGames);

        ResultUI.printByDTO(namedCarClient.convertToCarDTOs());
    }

    List<CarDTO> convertToCarDTOs() {
        List<CarDTO> carDTOs = new ArrayList<CarDTO>(cars.size());
        for (NamedCar car : cars) {
            carDTOs.add(new CarDTO(car.getName(), car.getPosition()));
        }
        return carDTOs;
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
