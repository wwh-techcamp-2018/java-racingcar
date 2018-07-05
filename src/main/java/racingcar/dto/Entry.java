package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Entry {
    private List<Car> entry;

    public Entry(List<Car> entry) {
        this.entry = entry;
    }

    public Entry(Car participant) {
        this();
        this.entry.add(participant);
    }

    public Entry() {
        this.entry = new ArrayList<>();
    }

    public List<Car> getEntry() {
        return entry;
    }

    public void add(Car participant) {
        this.entry.add(participant);
    }
}
