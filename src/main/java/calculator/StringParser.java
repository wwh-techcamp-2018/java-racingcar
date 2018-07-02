package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringParser {
    private final List<String> operators = Arrays.asList("+", "-", "*", "/");

    private List<Integer> numbers = new ArrayList<>();
    private List<String> operatorList = new ArrayList<>();
    private int numCount = 0;
    private int opCount = 0;

    public void setInput(String input) {
        if (input.equals("") || input == null) {
            throw new IllegalArgumentException();
        }

        String[] strings = input.split(" ");
        for(int i=0; i<strings.length; i++) {
            parseToken(strings[i]);
        }
    }

    public void parseToken(String token) {
        if(operators.contains(token)) {
            operatorList.add(token);
            return;
        }
        numbers.add(Integer.parseInt(token));
    }

    public int nextNum() {
        return numbers.get(numCount++);
    }

    public int getOperatorCount() {
        return operatorList.size();
    }

    public String nextOperator() {
        return operatorList.get(opCount++);
    }

}
