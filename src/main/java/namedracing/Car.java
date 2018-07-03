package namedracing;

class Car {
    private final int THRESHOLD = 4;

    private int position;

    private String name;

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }


    int moveCar(int randomNumber) {
        if(isMovable(randomNumber)) {
            return ++this.position;
        }
        return this.position;
    }

    public boolean isMovable(int randomNumber) {
        if(randomNumber >= THRESHOLD) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}