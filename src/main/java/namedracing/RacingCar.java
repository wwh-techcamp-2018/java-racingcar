package namedracing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private final int MAX_BOUND = 10;


    List<Car> cars = new ArrayList<Car>();
    int times;

    Scanner scanner = new Scanner(System.in);
    int maxDistance = 0;

    void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = getInputNames();
        for(int i = 0; i < names.length; ++i) {
            cars.add(new Car(names[i], 0));
        }
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.times = getInputInteger();
        System.out.println();
    }

    int getInputInteger() {
        String value = scanner.nextLine();
        return Integer.valueOf(value);
    }

    String[] getInputNames(){
        String value = scanner.nextLine();
        return value.split(",");
    }


    public void move() {
        for(int i = 0; i < cars.size(); ++i) {
            attemptMoves(i);
        }
    }


    public void attemptMoves(int index) {
        for(int j = 0; j < this.times; ++j) {
            cars.get(index).moveCar(generateRandomNumber());
        }
    }

    int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }


    public void run() {
        getInput();
        move();
        new RaceResult(cars).printResultGame();
    }

}
