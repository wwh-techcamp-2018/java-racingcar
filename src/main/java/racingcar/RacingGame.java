package racingcar;

import util.IntegerUtil;
import util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int time;

    public RacingGame(String[] names, int time) {
        cars = new ArrayList();
        initCars(names);
        this.time = time;
    }

    private void initCars(String[] names) {
        for (int i = 0; i < names.length; i++) {
            addNewCar(new Car(0, names[i]));
        }
    }

    public void addNewCar(Car car) {
        cars.add(car);
    }

    public void moveAll() {
        int randomNum = 0;
        for (int i = 0; i < cars.size(); i++) {
            randomNum = IntegerUtil.getRandomNo();
            cars.get(i).move(randomNum);
        }
    }
    public int getMaxDist(){
        return Collections.max(cars, (car1, car2) -> car1.getPosition() - car2.getPosition()).getPosition();

    }
    public List<Car> getWinners(int max) {
        return cars.stream().filter((car) -> car.getPosition() == max).collect(Collectors.toList());
    }

    public String getWinnerText(List<Car> winners) {
        return winners.stream().map((car) -> car.getName()).collect(Collectors.joining(","));
    }

    public void printWinners() {
        System.out.print(getWinnerText(getWinners(getMaxDist())));
        System.out.println("가 최종 우승했습니다.");
    }

    public void printCarResult(int index){
        System.out.print(cars.get(index).getName()+ " : ");
        System.out.println(StringUtil.repeatDash(cars.get(index).getPosition()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = StringUtil.parseName(scanner.next());
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();
        RacingGame racingGame = new RacingGame(names, time);
        for (int i = 0; i < time; i++) {
            racingGame.moveAll();
        }
        System.out.println("\n실행 결과\n");
        for (int i = 0; i < names.length ; i++) {
            racingGame.printCarResult(i);
        }
        racingGame.printWinners();
    }
}
