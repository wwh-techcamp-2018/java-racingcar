package calculator.parser;

import java.util.List;

public interface StringParser {
    List<String> parse(String input);

    List<String> extractOperators(List<String> tokens);

    List<Integer> extractOperands(List<String> tokens);
}
