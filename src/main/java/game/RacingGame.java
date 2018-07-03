package game;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {
    private ArrayList<RacingCar> carList = new ArrayList<>();

    RacingGame(int num) {
        for (int i = 0; i < num; i++)
            carList.add(new RacingCar());
    }

    ArrayList<Integer> startGame(int time) {
        for (int i = 0; i < time; i++)
            rollDice();

        return this.getCarsPosition();
    }

    int getRandomNum() {
        return new Random().nextInt(10);
    }

    void rollDice() {
        for (RacingCar car : carList)
            car.moveForward(getRandomNum());
    }

    private ArrayList<Integer> getCarsPosition() {
        ArrayList<Integer> ps = new ArrayList<>();
        for (RacingCar car : carList) {
            ps.add(car.getPosition());
        }

        return ps;
    }

    ArrayList<RacingCar> getCarList() {
        return carList;
    }

    void printResult(ArrayList<Integer> result) {
        for (Integer position : result) {
            printDash(position);
            System.out.println();
        }
    }

    private void printDash(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}