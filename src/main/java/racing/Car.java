package racing;

public class Car {
    public static final int THRESHOLD = 4;
    private int position = 0;

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
