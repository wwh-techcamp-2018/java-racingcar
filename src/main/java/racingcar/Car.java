package racingcar;

public class Car {
    private int position = 0;
    static final int MOVE_THRESHOLD = 4;
    static final String MOVE_MARKER = "-";

    public void move(int randomNo) {
        if (randomNo >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public static String repeat(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(MOVE_MARKER);
        }
        return sb.toString();
    }
}