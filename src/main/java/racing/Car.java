package racing;

public class Car implements Comparable<Car> {
    private static final int LIMIT_NUM = 4;
    private int distance;
    private String name;

    public Car(String name) {
        this.distance = 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public int move(int num) {
        if (LIMIT_NUM <= num) {
            return ++this.distance;
        }
        return this.distance;
    }

    @Override
    public int compareTo(Car car) {
        if (this.distance < car.distance) {
            return 1;
        }
        if (this.distance == car.distance) {
            return 0;
        }
        return -1;
    }
}
