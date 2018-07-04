package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
