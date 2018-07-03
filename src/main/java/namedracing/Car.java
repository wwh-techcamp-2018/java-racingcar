package namedracing;

class Car {
    private final int THRESHOLD = 4;

    int position;

    String name;

    Car() {
        position = 0;
        name = "";
    }

    Car(int position) {
        this.position = position;
        this.name = "";
    }

    Car(String name) {
        position = 0;
        this.name = name;
    }


    Car(String name, int position) {
        this.name = name;
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