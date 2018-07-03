package namedracing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    private final int MAX_BOUND = 10;


    ArrayList<Car> cars = new ArrayList<Car>();
    ArrayList<Car> winners = new ArrayList<Car>();
    int times;
    Scanner scanner = new Scanner(System.in);
    int maxDistance = 0;

    void getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = getInputNames();
        for(int i = 0; i < names.length; ++i) {
            cars.add(new Car(names[i]));
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
            checkWinner(i);
        }
    }

    public void checkWinner(int index) {
        if(cars.get(index).position > maxDistance) {
            maxDistance = cars.get(index).position;
            winners.clear();
        }

        if(cars.get(index).position == maxDistance) {
            winners.add(cars.get(index));
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
        result.append(cars.get(index).name + " : ");
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

    public void printWinners() {
        StringBuilder result = new StringBuilder();
        result.append(winners.get(0).name);
        for(int i = 1; i < winners.size(); i++){
            result.append(", ");
            result.append(winners.get(i).name);
        }
        result.append("가 최종 우승했습니다.");
        System.out.println(result.toString());
    }


    public void run() {
        getInput();
        move();
        printCarPositions();
        printWinners();
    }

}
