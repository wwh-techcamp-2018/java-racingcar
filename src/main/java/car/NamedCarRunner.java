package car;

import car.domain.CarDTO;
import car.model.NamedCar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NamedCarRunner<T extends NamedCar> extends CarRunner {
    NamedCarRunner(List<T> cars) {
        super(cars);
    }

    List<CarDTO> convertToCarDTOs() {
        List<CarDTO> carDTOs = new ArrayList<CarDTO>(cars.size());
        Iterator<T> iterator = cars.iterator();
        while(iterator.hasNext()){
            T car = iterator.next();
            carDTOs.add(new CarDTO(car.getName(), car.getPosition()));
        }
        return carDTOs;
    }
}
