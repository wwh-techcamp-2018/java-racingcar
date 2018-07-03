package car.model;

public class NamedCar extends Car{
    private String name;
    public NamedCar(String name) {

        this.name = name;
    }

    public String getName(){
        return name;
    }
    // constructor//name 추가 // getter
}
