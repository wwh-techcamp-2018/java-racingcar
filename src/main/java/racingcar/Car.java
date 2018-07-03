package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private int position = 0;
    static final int MOVE_THRESHOLD = 4;
    static final String MOVE_MARKER = "-";

    public Car(String name) {
        this.name = name.trim();
    }

    public void move(int randomNo) {
        if (randomNo >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public static String repeat(String name, int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(MOVE_MARKER);
        }
        return name + " : " + sb.toString();
    }

    @Override
    public int compareTo(Car o) {
        if (o.getPosition() > position) {
            return 1;
        }
        if (o.getPosition() < position) {
            return -1;
        }
        return 0;
    }
}