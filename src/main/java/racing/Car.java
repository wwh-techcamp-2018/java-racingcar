package racing;

public class Car {
    public static final int THRESHOLD = 4;
    private int position = 0;
    private String name;

    public int move(int value) {
        if (value >= THRESHOLD) {
            return ++position;
        }
        return position;
    }

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getState(String carCharacter) {
        return String.format("%s\t%s\n", name, StringUtil.repeat(position, carCharacter));
    }
}
