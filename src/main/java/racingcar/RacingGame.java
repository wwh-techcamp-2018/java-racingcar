package racingcar;

import utility.StringUtility;

import java.util.*;

public class RacingGame {

    private List<Car> cars;
    private Map<Integer, List<String>> rankMap;

    public RacingGame(String input) {
        cars = new ArrayList<>();
        rankMap = new HashMap<>();

        String[] names = StringUtility.splitWithComma(input);
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void start(int times) {
        for (int i = 0; i < times; i++) {
            moveCars();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveWithCondition(getRandomNo());
        }
    }

    public int getRandomNo() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public String getRacingCar() {
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            sb.append(car.toString());
        }
        return sb.toString();
    }

    public String getWinners() {
        StringBuffer sb = new StringBuffer();
        sb.append(StringUtility.joinWithComma(getWinnerNameList()));
        sb.append("가 최종우승했습니다.");
        return sb.toString();
    }

    public List<String> getWinnerNameList() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
            rank(car);
        }
        return rankMap.get(maxPosition);
    }

    public void rank(Car car) {
        int position = car.getPosition();
        List<String> names = rankMap.get(position);
        if (null == names)
            names = new ArrayList<>();

        names.add(car.getName());
        rankMap.put(position, names);
    }

}
