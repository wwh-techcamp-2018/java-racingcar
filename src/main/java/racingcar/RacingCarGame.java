package racingcar;


import java.util.*;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();

    public RacingCarGame(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void tryMove(Car car, int numTrial) {
        Random random = new Random();
        for (int i = 0; i < numTrial; i++) {
            car.move(random.nextInt(10));
        }
    }

    public void run(int numTrial) {
        for (Car car : cars) {
            this.tryMove(car, numTrial);
        }
    }

    public void registerIfWinner(List<String> winners, Car car) {
        if (cars.get(0).getPosition() == car.getPosition())
            winners.add(car.getName());
    }

    public void printCarState() {
        for (Car car : cars) {
            System.out.println(Car.repeat(car.getName(), car.getPosition()));
        }
    }

    public List<String> getWinners() {
        Collections.sort(cars);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            registerIfWinner(winners, car);
        }
        return winners;
    }

    public void printWinners() {
        List<String> winners = getWinners();
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.print(winners.get(winners.size() - 1) + "가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RacingCarGame game;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String[] names = scanner.nextLine().split(",");
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numTrial = scanner.nextInt();

        game = new RacingCarGame(names);
        game.run(numTrial);
        game.printCarState();
        game.printWinners();
    }

}
