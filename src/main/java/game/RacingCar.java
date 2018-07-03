package game;

public class RacingCar {
    private int position = 0;


    public int getPosition() {
        return position;
    }

    public int moveForward(int randomNum) {
        if(randomNum>=4)
            return ++this.position;

        return getPosition();
    }
}
