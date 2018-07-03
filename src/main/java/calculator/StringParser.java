package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final List<String> operators = Arrays.asList("+", "-", "*", "/");

    private List<Integer> numbers;
    private List<String> operatorList;
    private int currentNumIndex;
    private int currentOperatorIndex;

    public StringParser() {
        this.numbers = new ArrayList<>();
        this.operatorList = new ArrayList<>();
        this.currentNumIndex = 0;
        this.currentOperatorIndex = 0;
    }

    public String[] setInput(String input) {
        if (input.equals("") || input == null) {
            throw new IllegalArgumentException();
        }
        String[] strings = input.split(" ");
        parseTokens(strings);
        return strings;
    }

    private void parseTokens(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            parseToken(strings[i]);
        }
    }

    public void parseToken(String token) {
        if (operators.contains(token)) {
            operatorList.add(token);
            return;
        }
        numbers.add(Integer.parseInt(token));
    }

    public int nextNum() {
        return numbers.get(currentNumIndex++);
    }

    public int getOperatorCount() {
        return operatorList.size();
    }

    public String nextOperator() {
        return operatorList.get(currentOperatorIndex++);
    }

}
