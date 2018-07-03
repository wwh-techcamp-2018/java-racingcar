package racingcar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private static final String LOAD = "-";
    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    int move(int randomValue) {
        if (randomValue >= LIMIT_NUM)
            this.position++;
        return this.position;
    }

    boolean isSame(int max) {
        return this.position == max;
    }

    String getRoad() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(LOAD);
        }
        return sb.toString();
    }
}
