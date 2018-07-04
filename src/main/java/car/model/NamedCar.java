package car.model;

import java.util.Objects;

public class NamedCar extends Car{
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NamedCar namedCar = (NamedCar) o;
        return Objects.equals(name, namedCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    public NamedCar(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    // constructor//name 추가 // getter
}
