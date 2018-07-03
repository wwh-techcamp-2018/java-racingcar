package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private final int MAX_BOUND = 10;
    private final int THRESHOLD = 4;

    int cars[];
    int times;
    Scanner scanner = new Scanner(System.in);

    public int[] getCars() {
        return cars;
    }

    public void setCars(int[] cars) {
        this.cars = cars;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    void getInput() {
        System.out.println("자동차 대수는 몇대 인가요?");
        setCars(new int[getInputInteger()]);
        System.out.println("시도할 회수는 몇 회 인가요?");
        setTimes(getInputInteger());
        System.out.println();
    }

    int getInputInteger() {
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

    public void move() {
        for(int i = 0; i < getCars().length; ++i) {
            for(int j = 0; j < getTimes(); ++j) {
                if(isMovable(generateRandomNumber())) {
                    moveCar(i);
                }
            }
        }
    }

    public boolean isMovable(int randomNumber) {
        if(randomNumber >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public int moveCar(int index) {
        return ++getCars()[index];
    }

    int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public String generateOutString(int index) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < getCars()[index]; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public void printCarPositions() {
        System.out.println("실행 결과\n");
        for(int i = 0; i < getCars().length; i++) {
            System.out.println(generateOutString(i));
        }
    }

    public void run() {
        getInput();
        move();
        printCarPositions();
    }

}
