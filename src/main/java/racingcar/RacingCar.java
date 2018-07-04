package racingcar;

import java.util.Objects;

public class RacingCar {
    private static final int MOVE_MIN_STANDARD = 4;
    private String name;
    private int position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
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

    public boolean matchBy(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position &&
                Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, position);
    }

}