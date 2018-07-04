package car;

import car.domain.CarDTO;
import car.model.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CarRunner<T extends Car> {

    private static final int RANDOM_BOUND_NUM = 10;

    private List<T> cars;

    public CarRunner(List<T> cars){
        this.cars = cars;
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
        return new Random().nextInt(RANDOM_BOUND_NUM);
    }

    List<Integer> getPositions() {
        List<Integer> result = new ArrayList<Integer>(cars.size());
        for (Car car : cars) {
            result.add(car.getPosition());
        }
        return result;
    }

    protected List<T> getCars(){
        return cars;
    }
    protected Iterator<T> getCarIterator(){
        return cars.iterator();
    }

    public List<CarDTO> convertToCarDTOs(){
        List<CarDTO> carDTOs = new ArrayList<CarDTO>(cars.size());
        Iterator<T> iterator = cars.iterator();
        while(iterator.hasNext()){
            T car = iterator.next();
            carDTOs.add(car.createCarDTO());
        }
        return carDTOs;
    }

}
