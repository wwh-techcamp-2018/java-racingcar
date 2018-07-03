package game;

import java.util.List;

public class ResultView {
    void printResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            printDash(car.getPosition());
            System.out.println();
        }
    }

    private void printDash(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
