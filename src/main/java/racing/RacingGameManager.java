package racing;

import racing.common.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGameManager {
    private List<Car> cars;
    private List<String> winnersNameList;

    public RacingGameManager() {
        cars = new ArrayList<>();
        winnersNameList = new ArrayList<>();
    }

    public int initGame(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
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

    void moveCars(int count) {
        for (Car car : cars) {
            moveCar(count, car);
        }
    }

    void sort() {
        Collections.sort(cars);
    }

    void printResult() {
        for (int i = 0; i < cars.size(); i++) {
            StringUtils.println(cars.get(i).getName() + " : " + StringUtils.createDash(cars.get(i).getDistance()));
        }
    }

    boolean judgeWinner(Car car, int max) {
        if (car.getDistance() == max) {
            winnersNameList.add(car.getName());
            return true;
        }
        return false;
    }

    private void judgeWinners() {
        int max = cars.get(0).getDistance();
        for (int i = 0; i < cars.size(); i++) {
            judgeWinner(cars.get(i), max);
        }
    }

    void printWinner() {
        for (int i = 0; i < winnersNameList.size() - 1; i++) {
            StringUtils.print(winnersNameList.get(i) + ", ");
        }
        StringUtils.print(winnersNameList.get(winnersNameList.size() - 1));

        StringUtils.println("가 최종 우승했습니다.");
    }

    public void runGame(int count) {
        moveCars(count);
        printResult();
        sort();
        judgeWinners();
        printWinner();
    }

}
