package racingcar.utils;

public class StaticGenerator implements Generator {
    private int ticket;

    public StaticGenerator(int ticket) {
        this.ticket = ticket;
        if (ticket > TICKET_UPPER_BOUND)
            this.ticket = TICKET_UPPER_BOUND;
        if (ticket < TICKET_LOWER_BOUND)
            this.ticket = TICKET_LOWER_BOUND;
    }

    @Override
    public int generate() {
        return ticket;
    }
}
