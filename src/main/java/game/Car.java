package game;

public class Car {
    public final static int FORWARD_NUM = 4;
    public final static int MINIMUM = 0;
    public final static int MAXIMUM = 10;
    private int position;

    public Car() {
        position = 0;
    }

    public void movePosition(int num) {
        if (num < MINIMUM || num > MAXIMUM)
            throw new IllegalStateException();
        if (num >= FORWARD_NUM)
            this.position++;
    }

    public int getPosition() {
        return this.position;
    }

}
