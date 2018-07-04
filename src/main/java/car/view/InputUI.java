package car.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUI {
    static final String DELIMITER = ",";
    private Scanner scanner;

    public InputUI() {
        scanner = new Scanner(System.in);
    }

    public int getNumOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int num = Integer.parseInt(scanner.nextLine());
        return num;
    }

    public List<String> getCarNames() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return parseCarNames(scanner.nextLine());
    }

    public List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }

    public int getNumOfGames() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int num = scanner.nextInt();
        return num;
    }


}
