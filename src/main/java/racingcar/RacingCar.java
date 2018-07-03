package racingcar;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private final int MAX_BOUND = 10;


    ArrayList<Car> cars = new ArrayList<Car>();
    int times;
    Scanner scanner = new Scanner(System.in);

    void getInput() {
        System.out.println("자동차 대수는 몇대 인가요?");
        int carCount = getInputInteger();
        for(int i = 0; i < carCount; ++i) {
            cars.add(new Car());
        }
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.times = getInputInteger();
        System.out.println();
    }

    int getInputInteger() {
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

    public void move() {
        for(int i = 0; i < cars.size(); ++i) {
            attemptMoves(i);
        }
    }

    public void attemptMoves(int index) {
        for(int j = 0; j < this.times; ++j) {
            if(cars.get(index).isMovable(generateRandomNumber())) {
                cars.get(index).moveCar();
            }
        }
    }

    int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public String generateOutString(int index) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < cars.get(index).position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public void printCarPositions() {
        System.out.println("실행 결과\n");
        for(int i = 0; i < cars.size(); i++) {
            System.out.println(generateOutString(i));
        }
    }

    public void run() {
        getInput();
        move();
        printCarPositions();
    }

}
