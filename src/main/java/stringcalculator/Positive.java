package stringcalculator;

public class Positive {
    private int value;

    public Positive() {
        this.value = 0;
    }

    public Positive(String s) {
        this.value = Integer.valueOf(s);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public Positive add(Positive b) {
        Positive result = new Positive();
        result.setValue(this.value + b.getValue());
        return result;
    }


}
