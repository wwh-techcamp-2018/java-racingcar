package racingcar.utils;

public interface Generator {
    int TICKET_UPPER_BOUND = 9;
    int TICKET_LOWER_BOUND = 0;

    int generate();
}
