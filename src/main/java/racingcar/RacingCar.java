package racingcar;

public class RacingCar {
    private static final int MOVE_MIN_STANDARD = 4;
    private int position;

    public int move(int randomNo) {
        if (randomNo >= MOVE_MIN_STANDARD) {
            return ++position;
        }
        return position;
    }

    public static String makePositionToString(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}