package racing.game1;

import java.util.*;

public class RacingGame {
    private List<Car> cars = new ArrayList<Car>();

    public RacingGame(String[] names) {
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public static void main(String args[]) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(",");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scan.nextInt();
        RacingGame racingGame = new RacingGame(names);

        racingGame.total(time, (ArrayList) racingGame.cars);
        racingGame.getState((ArrayList) racingGame.cars);
    }

    public void total(int time, ArrayList<Car> carPosition) {
        for (int i = 0; i < time; i++) {
            updatePosition(carPosition);
        }
    }


    private void updatePosition(ArrayList<Car> carPosition) {
        for (int i = 0; i < carPosition.size(); i++) {
            carPosition.get(i).move(RacingGame.random());
        }
    }

    public void getState(ArrayList<Car> cars) {
        StringBuilder str = new StringBuilder();
        for (Car car : cars) {
            str.append(car.getName());
            str.append(" : ");
            str.append(Car.getState(car.getPosition()));
            print(str.toString());
            str = new StringBuilder();
        }
        print(RacingGame.getWinner(cars));

    }


    private void print(String result) {
        System.out.println(result);
    }


    public static String getWinner(ArrayList<Car> cars) {
        Winner winner = new Winner();
        for (Car car : cars) {
            winner.isDraw(car);
            winner.isWin(car);
        }

        return winner.getWinners().append("가 최종 우승했습니다.").toString();
    }


    static int random() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
