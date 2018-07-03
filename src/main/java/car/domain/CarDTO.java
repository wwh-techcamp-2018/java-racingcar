package car.domain;

public class CarDTO implements Comparable {
    // final name, position
    // constructor  (Car)
    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Object o) {
        int position = ((CarDTO) o).getPosition();
        return position < this.position ? -1 : position == this.position ? 0 : 1;
    }
}
