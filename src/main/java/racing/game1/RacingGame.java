package racing.game1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private final static int LIMIT = 4;
    private final static String TEXT = "-";

    public static void main(String args[]) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scan.nextInt();
        ArrayList<Integer> carPosition = new ArrayList<Integer>(Collections.nCopies(num, 0));
        total(time, carPosition);
        getState(carPosition);
    }

    static int move(int random) {
        if (random >= LIMIT)
            return 1;
        return 0;
    }


    static void total(int time, ArrayList<Integer> carPosition) {
        for (int i = 0; i < time; i++) {
            updatePosition(carPosition);
        }
    }

    static int forward(int positionNum, int zeroOrOne) {
        return positionNum + zeroOrOne;
    }

    static void updatePosition(ArrayList<Integer> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            carPosition.set(i, forward(carPosition.get(i), move(random())));
        }
    }

    public static void print(String result) {
        System.out.println(result);
    }

    static String changeState(int positionNum) {
        String result = "";
        for (int i = 0; i < positionNum; i++) {
            result += TEXT;
        }
        return result;
    }

    static void getState(ArrayList<Integer> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            print(changeState(carPosition.get(i)));
        }
    }

    static int random() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
