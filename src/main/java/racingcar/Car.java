package racingcar;

class Car {
    private final int THRESHOLD = 4;

    int position;

    Car() {
        position = 0;
    }

    Car(int position) {
        this.position = position;
    }

    int moveCar() {
        return ++this.position;
    }

    public boolean isMovable(int randomNumber) {
        if(randomNumber >= THRESHOLD) {
            return true;
        }
        return false;
    }

}