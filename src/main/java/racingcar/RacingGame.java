package racingcar;

import utility.StringUtility;

import java.util.*;

public class RacingGame {

    private List<Car> cars;
    private List<String> winnerNames;
    private int maxPosition = 0;

    public RacingGame() {
        cars = new ArrayList<>();
        winnerNames = new ArrayList<>();
    }

    public void setCarNames(String input) {
        if (null == input) {
            throw new IllegalArgumentException("입력이 꼭 필요합니다.");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }

        String[] names = StringUtility.splitWithComma(input);
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void run(int times) {
        if (cars.isEmpty()) {
            throw new RuntimeException("게임을 시작하기 위해서는 자동차의 이름을 먼저 설정해야 합니다.");
        }
        if (times < 1) {
            throw new IllegalArgumentException("게임 횟수는 1보다 작을 수 없습니다.");
        }

        for (int i = 0; i < times; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int position = car.move();
            maxPosition = Math.max(maxPosition, position);
        }
    }

    public String getRacingCar() {
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            sb.append(car.toString());
        }
        return sb.toString();
    }

    public String getWinners() {
        pickWinners();
        StringBuffer sb = new StringBuffer();
        sb.append(StringUtility.joinWithComma(winnerNames));
        sb.append("가 최종우승했습니다.");
        return sb.toString();
    }

    private void pickWinners() {
        for (Car car : cars) {
            addWinnerName(car);
        }
    }

    private void addWinnerName(Car car) {
        if (car.isReached(maxPosition))
            winnerNames.add(car.getName());
    }
}
