package adder;

import java.util.Arrays;

public class StringAdder {
    private Parser parser;

    public StringAdder(Parser parser) {
        this.parser = parser;
    }

    public int add(String inputString) {
        if (inputString == null || inputString.isEmpty()) return 0;

        return Arrays.stream(parser.parse(inputString))
                .mapToInt(StringAdder::toPositiveInteger)
                .sum();
    }

    static int toPositiveInteger(String numString) {
        int result = Integer.parseInt(numString);
        if (result < 0) {
            throw new RuntimeException();
        }
        return result;
    }
}
