package racingcar.dto;

import java.util.Objects;

public class RacingGameResult {
    private Entry entry;
    private Entry winners;

    public RacingGameResult(Entry entry, Entry winners) {
        this.entry = entry;
        this.winners = winners;
    }

    public Entry getWinners() {
        return winners;
    }

    public Entry getEntry() {
        return entry;
    }

}
