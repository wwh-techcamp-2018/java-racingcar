package racing;

public class Car {
    private int position = 0;
    public static final int THRESHOLD = 4;

    public int move(int value) {
        if (value >= THRESHOLD) {
            return ++position;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }
}
