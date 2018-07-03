package game;

public class ResultView {
    void printResult(RacingGame game) {
        for (RacingCar car : game.getCars()) {
            System.out.print(car.getName() + " : ");
            printDash(car.getPosition());
            System.out.println();
        }

        System.out.println(String.join(", ", game.getWinners()) + "가 최종 우승했습니다.");
    }

    private void printDash(Integer position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }
}
