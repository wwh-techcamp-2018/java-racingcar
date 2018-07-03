package race;

public class Car {
    private int position = 0;

    int moveFront() {
        return position += 1;
    }

    public int getPosition() {
        return position;
    }
}
