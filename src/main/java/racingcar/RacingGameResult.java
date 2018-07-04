package racingcar;

import java.util.List;

public class RacingGameResult {
    private List<RacingCar> cars;
    private List<RacingCar> winners;

    public RacingGameResult(List<RacingCar> cars, List<RacingCar> winners) {
        this.cars = cars;
        this.winners = winners;
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public List<RacingCar> getWinners() {
        return winners;
    }
}
