package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsFactory {
    public static List<RacingCar> create(String carNames) {
        return createCars(split(carNames));
    }

    private static List<RacingCar> createCars(String[] carNames) {
        List<RacingCar> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new RacingCar(carName));
        }
        return cars;
    }

    private static String[] split(String intputText) {
        return intputText.split(",");
    }
}
