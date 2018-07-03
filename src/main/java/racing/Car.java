package racing;

public class Car {
    private static final int LIMIT_NUM = 4;
    private int distance = 0;

    public int move(int num) {
        if (LIMIT_NUM < num) {
            return ++this.distance;
        }
        return this.distance;
    }

    public int getDistance() {
        return this.distance;
    }
}
