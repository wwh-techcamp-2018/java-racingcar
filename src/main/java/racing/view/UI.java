package racing.view;

import racing.common.StringUtils;
import racing.model.RacingGameManager;
import racing.model.RandomValueGenerator;
import racing.model.ValueGenerator;

import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StringUtils.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputName = scanner.nextLine();
        StringUtils.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        ValueGenerator valueGenerator = new RandomValueGenerator();

        RacingGameManager racingGameManager = new RacingGameManager(StringUtils.tokenizer(inputName), valueGenerator);
        StringUtils.println(racingGameManager.runGame(count));
    }
}
