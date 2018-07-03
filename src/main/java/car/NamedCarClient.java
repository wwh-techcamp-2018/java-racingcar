package car;

import car.domain.CarDTO;
import car.model.NamedCar;
import car.view.InputUI;
import car.view.ResultUI;

import java.util.ArrayList;
import java.util.List;

public class NamedCarClient {

    NamedCarRunner<NamedCar> runner;

    public NamedCarClient(List<String> carList) {
        List<NamedCar> cars = new ArrayList<NamedCar>(carList.size());
        for (String name : carList) {
            cars.add(new NamedCar(name));
        }
        runner = new NamedCarRunner<NamedCar>(cars);
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
    public void run(int numOfGames) {
       runner.run(numOfGames);
    }
    List<CarDTO> convertToCarDTOs() {
        return runner.convertToCarDTOs();
    }

}
