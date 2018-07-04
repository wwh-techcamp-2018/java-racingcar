package calculator.string.adder;

import java.util.List;

class StringAddCalculator {
    public static int sum(List<Integer> numbers) {
        return numbers.stream().reduce((a, b) -> a + b).orElse(0);
    }
}
