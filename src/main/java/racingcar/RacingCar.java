package racingcar;

public class RacingCar {
    private static final int MOVE_MIN_STANDARD = 4;
    private String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}