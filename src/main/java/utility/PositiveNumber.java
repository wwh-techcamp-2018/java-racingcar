package utility;

import java.util.Objects;

public class PositiveNumber {

    private int number;

    private PositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static PositiveNumber of(int number) { return new PositiveNumber(number); }

    public static PositiveNumber of(String number) { return PositiveNumber.of(Integer.parseInt(number)); }

    public PositiveNumber increment() { return PositiveNumber.of(number + 1); }

    public int toInt() { return this.number; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
