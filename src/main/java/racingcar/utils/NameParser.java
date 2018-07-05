package racingcar.utils;

import java.util.Arrays;

public class NameParser {
    public static String[] parse(String names) {
        return Arrays.stream(names.split(",")).map(String::trim).toArray(String[]::new);
    }
}
