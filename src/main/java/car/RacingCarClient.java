package car;

import java.util.Random;

public class RacingCarClient {
    private Car[] cars;

    public static void main(String[] args) {
        InputUI inputUI = new InputUI();
        int numOfCars = inputUI.getNumOfCars();
        int numOfGames = inputUI.getNumOfGames();

        RacingCarClient client = new RacingCarClient();
        client.initialize(numOfCars);
        client.run(numOfGames);

        ResultUI resultUI = new ResultUI();
        resultUI.printGame(client.getPositions());
    }

    public void initialize(int numOfCars) {
        cars = new Car[numOfCars];
        for (int i = 0; i < numOfCars; i++) {
            cars[i] = new Car();
        }
    }

    public void run(int numOfGames) {
        for (int i = 0; i < numOfGames; i++) {
            moveCars();
        }
    }

    void moveCars() {
        for (int i = 0; i < cars.length; i++) {
            cars[i].move(getRandomNum());
        }
    }

    int getRandomNum() {
        return new Random().nextInt(10);
    }

    int[] getPositions() {
        int[] result = new int[cars.length];
        for (int i = 0; i < cars.length; i++) {
            result[i] = cars[i].getPosition();
        }
        return result;
    }

}
