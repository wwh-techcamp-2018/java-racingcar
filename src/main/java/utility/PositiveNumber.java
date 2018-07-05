package utility;

public class PositiveNumber {

    private int number;

    public PositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public PositiveNumber(String s) {
        this(Integer.parseInt(s));
    }

    public int toInt() {
        return this.number;
    }
}
