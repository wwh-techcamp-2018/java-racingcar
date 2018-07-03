package race;

public class Car {
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
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
