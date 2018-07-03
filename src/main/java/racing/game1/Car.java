package racing.game1;

public class Car {
    private final static int LIMIT = 4;
    private final static String TEXT = "-";
    private int position = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(int random) {
        if (random >= LIMIT)
            this.position++;

    }

    public String getName() {
        return name;
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

    public boolean isWin(int highScore){
        if(this.position > highScore)
            return true;
        return false;
    }

    public boolean isDraw(int highScore){
        if(this.position == highScore)
            return true;
        return false;
    }

}

