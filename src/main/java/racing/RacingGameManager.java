package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameManager {
    private List<Car> cars;

    public RacingGameManager() {
        cars = new ArrayList<>();
    }

    public int initGame(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        return cars.size();
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int moveCar(int count, Car car) {
        for (int i = 0; i < count; i++) {
            car.move(getRandomNum());
        }
        return car.getDistance();
    }

    private void moveCars(int count) {
        for (Car car : cars) {
            moveCar(count, car);
        }
    }

    String createDash(int num) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < num; i++) {
            st.append("-");
        }
        return st.toString();
    }

    private void print(String dash) {
        System.out.println(dash);
    }

    private void printResult() {
        for (int i = 0; i < cars.size(); i++) {
            print(createDash(cars.get(i).getDistance()));
        }
    }

    public void runGame(int count) {
        moveCars(count);
        printResult();
    }

}
