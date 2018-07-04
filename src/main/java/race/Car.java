package race;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    int moveFront() {
        return position += 1;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isOnPosition(Car car) {
        return this.position == car.position;
    }

    public Car getWinner(Car car) {
        return this.position > car.position ? this : car;
    }
}
