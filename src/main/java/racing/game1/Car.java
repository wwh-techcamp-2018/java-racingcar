package racing.game1;

import racing.game1.generator.RandomValueGenerator;
import racing.game1.generator.ValueGenerator;

public class Car {
    private final static int LIMIT = 4;
    private final static String TEXT = "-";
    private int position = 0;
    private String name;
    ValueGenerator vg;

    public Car(String name) {
        this(name, new RandomValueGenerator(), 0);
    }

    public Car(String name, ValueGenerator vg) {
        this(name, vg, 0);
    }

    public Car(String name, int position) {
        this(name, new RandomValueGenerator(), position);
    }

    public Car(String name, ValueGenerator vg, int position) {
        this.name = name;
        this.vg = vg;
        this.position = position;
    }

    public void move() {
        if (vg.nextInt() >= LIMIT)
            this.position++;

    }

    public int getPosition() {
        return this.position;
    }

    public static String getState(int position) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < position; i++) {
            str.append(TEXT);
        }
        return str.toString();
    }

    public boolean isWin(int highScore) {
        if (this.position > highScore)
            return true;
        return false;
    }

    public boolean isDraw(int highScore) {
        if (this.position == highScore)
            return true;
        return false;
    }

    public StringBuilder appendWinner(StringBuilder winners) {
        if(winners.toString().isEmpty()){
            return winners.append(this.name);
        }
        return winners.append(",").append(name);
    }

    public int getMaxPosition(int maxPosition) {
        if(this.position > maxPosition)
            return this.position;
        return maxPosition;
    }

    public boolean isWinner(int maxPosition) {
        if(this.position == maxPosition)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return this.name+": "+getState(this.position);
    }
}

