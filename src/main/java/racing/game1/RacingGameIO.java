package racing.game1;

import java.util.*;

public class RacingGameIO {
    private List<Car> cars = new ArrayList<Car>();

    public RacingGameIO(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public static void main(String args[]) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scan.nextInt();
        RacingGameIO racingGameIO = new RacingGameIO(names);
        RacingGame racingGame = new RacingGame();

        racingGame.total(time, racingGameIO.cars);
        racingGameIO.getState(racingGameIO.cars);
    }


    private void print(String result) {
        System.out.println(result);
    }

    public void getState(List<Car> cars) {
        for (Car car : cars) {
                        print(car.appendCarNameAndState());
        }
        print(RacingGame.getWinner(cars));
    }


}
