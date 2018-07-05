package racingcar.domain;

import racingcar.dto.RacingGameInput;
import racingcar.utils.NameParser;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static RacingGameInput getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int numTrial = scanner.nextInt();
        // TODO: 2018. 7. 4. 입력 문자열의 유효성 검사가 필요합니다. 
        return new RacingGameInput(NameParser.parse(names), numTrial);
    }
}
