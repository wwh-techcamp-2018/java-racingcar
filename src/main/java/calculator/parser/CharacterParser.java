package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CharacterParser implements StringParser {

    private static final int CUSTOM_D_LENGTH = 4;
    private static final int CUSTOM_D_POS = 2;

    private String delimiter;

    public CharacterParser() {
        delimiter = ",|;";
    }

    @Override
    public List<String> parse(String input) {
        if (input == null) {
            return Arrays.asList("0");
        }
        if (input.isEmpty()) {
            return Arrays.asList("0");
        }

        if (findCustomDelimiter(input)) {
            delimiter = changeDelimiter(input);
            input = removeCustomDelimiter(input);
        }

        return Arrays.asList(input.split(delimiter));
    }

    public boolean findCustomDelimiter(String input) {
        return Pattern.compile("//\\D\n").matcher(input).find();
    }

    public String changeDelimiter(String input) {
        String custom = input.substring(0, CUSTOM_D_LENGTH);
        return String.valueOf(custom.charAt(CUSTOM_D_POS));
    }

    public String removeCustomDelimiter(String input) {
        return input.substring(CUSTOM_D_LENGTH);
    }

    @Override
    public List<String> extractOperators(List<String> tokens) {
        String[] plus = new String[tokens.size() - 1];
        Arrays.fill(plus, "+");
        return Arrays.asList(plus);
    }

    @Override
    public List<Integer> extractOperands(List<String> tokens) {
        return tokens.stream().map(Integer::parseInt).map(i -> findNegativeNumeric(i)).collect(Collectors.toList());
    }

    public int findNegativeNumeric(int num) {
        if (num < 0)
            throw new RuntimeException();
        return num;
    }
}
