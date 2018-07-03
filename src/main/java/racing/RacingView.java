package racing;

import java.util.Scanner;

public class RacingView {
    private boolean isFirstWinnerMessage = true;
    private Scanner scanner = new Scanner(System.in);

    public String getInputString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int getInputInteger(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    public void printCarResult(Car car) {
        System.out.println(RacingUtil.buildResult(car));
    }

    public void printWinner(Car car, int maxPosition) {
        if (!car.isWinner(maxPosition))
            return;

        if (isFirstWinnerMessage) {
            isFirstWinnerMessage = false;
            System.out.print(car.getName());
            return;
        }
        System.out.print(String.format(RacingConst.WINNER_NAME_FORMAT, car.getName()));
    }

    public void printWinnerPostfix() {
        System.out.println(RacingConst.WINNER_MESSAGE_POSTFIX);
    }
}
