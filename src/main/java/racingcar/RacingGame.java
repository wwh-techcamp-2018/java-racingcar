package racingcar;

import util.IntegerUtil;
import util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.RacingGameView.getNames;
import static racingcar.RacingGameView.getTime;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(String[] names) {
        cars = new ArrayList();
        initCars(names);
    }

    private void initCars(String[] names) {
        for (String name: names) {
            cars.add(new Car(0, name));
        }
    }

    public void printResult() {
        RacingGameView.printCarResult(cars);
        RacingGameView.printWinners(getWinnerText(getWinners(cars, getMaxDist(cars))));
    }

    public void moveAll() {
        int randomNum = 0;
        for (int i = 0; i < cars.size(); i++) {
            randomNum = IntegerUtil.getRandomNo();
            cars.get(i).move(randomNum);
        }
    }
    public static int getMaxDist(List<Car> cars){
        return Collections.max(cars, (car1, car2) -> car1.getPosition() - car2.getPosition()).getPosition();

    }
    public static List<Car> getWinners(List<Car> cars, int max) {
        return cars.stream().filter((car) -> car.getPosition() == max).collect(Collectors.toList());
    }

    public static String getWinnerText(List<Car> winners) {
        return winners.stream().map((car) -> car.getName()).collect(Collectors.joining(","));
    }


    public static void main(String[] args) {
        String[] names = getNames();
        int time = getTime();

        RacingGame racingGame = new RacingGame(names);
        for (int i = 0; i < time; i++) {
            racingGame.moveAll();
        }
        racingGame.printResult();
    }
}
