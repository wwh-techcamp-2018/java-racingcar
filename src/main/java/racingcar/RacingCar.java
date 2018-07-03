package racingcar;

public class RacingCar {
    private int position;

    public int move(int randomNo) {
        if (randomNo >= 4) {
            return ++position;
        }
        return position;
    }

    public String makePositionToString(int position) {
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