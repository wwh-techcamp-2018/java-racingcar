package racing.game1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private ArrayList<Car> cars = new ArrayList<Car>();

    public RacingGame(int num) {
        for(int i = 0 ; i < num ; i++){
            cars.add(new Car());
        }
    }


    public static void main(String args[]) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scan.nextInt();
        RacingGame racingGame = new RacingGame(num);

        racingGame.total(time,racingGame.cars);
        racingGame.getState(racingGame.cars);
    }

    public void total(int time, ArrayList<Car> carPosition) {
        for (int i = 0; i < time; i++) {
            updatePosition(carPosition);
        }
    }


    private void updatePosition(ArrayList<Car> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            carPosition.get(i).move(random());
        }
    }

    public void getState(ArrayList<Car> cars){
        for(Car car : cars){
            print(car.getState(car.getPosition()));
        }
    }

    private void print(String result) {
        System.out.println(result);
    }


    private int random() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
