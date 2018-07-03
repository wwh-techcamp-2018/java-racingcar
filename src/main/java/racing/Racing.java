package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Racing {
    private static final char DASH = '-';
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String WINNER_NAME_FORMAT = ", %s";
    private static final String WINNER_MESSAGE_POSTFIX = "%s가 최종 우승했습니다.";

    public static void main(String[] args) {
        Racing racing = new Racing();
        racing.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int count = scanner.nextInt();

        ArrayList<Car> cars = makeCars(parseCarNames(carNames));
        for (int i = 0; i < count; i++) {
            drive(cars);
        }
        printResult(cars);
    }

    static ArrayList<String> parseCarNames(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }

    private ArrayList<Car> makeCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void drive(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.run();
        }
    }

    private void printResult(ArrayList<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            System.out.println(buildResult(car));
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        ArrayList<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition)
                winners.add(car);
        }
        System.out.println(buildWinnerMessage(winners));
    }

    static String buildResult(Car car) {
        return String.format(RESULT_FORMAT, car.getName(), buildDash(car.getPosition()));
    }

    static String buildWinnerMessage(ArrayList<Car> winners) {
        if (winners.isEmpty())
            throw new IllegalArgumentException();

        // 우승자 메세지 빌드를 편하게 하기 위하여
        // 첫 번째 인덱스 이름을 먼저 StringBuilder에 붙이고
        // 이 후 이름들은 [, [이름]]으로 붙인다.
        StringBuilder builder = new StringBuilder();
        builder.append(winners.get(0).getName());
        for (int i = 1; i < winners.size(); i++) {
            builder.append(String.format(WINNER_NAME_FORMAT, winners.get(i).getName()));
        }
        return String.format(WINNER_MESSAGE_POSTFIX, builder);
    }

    static String buildDash(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(DASH);
        }
        return builder.toString();
    }
}
