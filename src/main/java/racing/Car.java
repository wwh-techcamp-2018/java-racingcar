package racing;

import java.util.Random;

public class Car {

    public static final int BOUNDARY_NUM = 4;
    public static final String MOVE_BAR = "-";
    private int position;

    public int getPosition() {
        return position;
    }

    public int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean move(int randomNumber) {
        if (randomNumber >= BOUNDARY_NUM) {
            this.position++;
            return true;
        }
        return false;
    }

    public void race(int num) {
        for (int i = 0; i < num; i++) {
            move(getRandom());
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getPosition(); i++) {
            sb.append(MOVE_BAR);
        }
        return sb.toString();
    }
}
