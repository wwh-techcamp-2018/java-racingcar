package racing.game1;

import java.util.List;

public class ResultView {
    public static void printResult(List<Car> cars, String winners){
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println(winners+"가 우승 했습니다.");

    }
}
