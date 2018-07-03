package racing;

import java.util.Random;

public class Car {
    private static final int GO_DEGREE = 4;
    private static final int MAX_RANDOM = 10;
    private static final int MIN_RANDOM = 0;

    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    private static int getRandomNum() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM);
    }

    public void run() {
        move(getRandomNum());
    }

    void move(int randomNum) {
        if (randomNum < MIN_RANDOM || randomNum > MAX_RANDOM)
            throw new IllegalStateException();
        if (randomNum >= GO_DEGREE)
            this.position++;
    }
}
