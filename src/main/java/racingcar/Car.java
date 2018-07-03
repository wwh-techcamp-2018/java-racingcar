package racingcar;

public class Car {
    private int position = 0;
    public void move(int randomNo) {
        if (randomNo > 3) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String repeat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
