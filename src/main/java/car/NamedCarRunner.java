package car;

import car.domain.CarDTO;
import car.model.NamedCar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NamedCarRunner<T extends NamedCar> extends CarRunner {
    public NamedCarRunner(List<T> cars) {
        super(cars);
    }
}
