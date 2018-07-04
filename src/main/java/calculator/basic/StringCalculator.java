package calculator.basic;


import java.util.HashMap;
import java.util.Map;

public class StringCalculator {

    private static final String ADDER = "+";
    private static final String SUBSTRACTOR = "-";
    private static final String MULTIPLIER = "*";
    private static final String DIVIDER = "/";
    private static final boolean VALID = true;
    private static final boolean INVALID = false;
    private static final String DELIMITER = " ";

    Map<String, Operator> operatorMap;

    public StringCalculator() {
        // Map에 put (모든 연산자)
        operatorMap = new HashMap<String, Operator>();
        operatorMap.put(ADDER, new Adder());
        operatorMap.put(SUBSTRACTOR, new Substractor());
        operatorMap.put(MULTIPLIER, new Multiplier());
        operatorMap.put(DIVIDER, new Divider());
    }

    int calculate(String input) {
        //전체 로직 (다른 메소드) 호출 및 결과 반환
        String[] inputs = parse(input);
        if (!isValidate(inputs)) throw new IllegalArgumentException();
        int result = Integer.parseInt(inputs[0]);

        for (int i = 1; i < inputs.length - 1; i += 2) {
            if (!isValidateOperator(inputs[i], inputs[i + 1])) throw new IllegalArgumentException();
            result = callOperator(result, inputs[i], inputs[i + 1]);
        }

        return result;
    }

    int callOperator(int preArgument, String operator, String postArgument) {
        return operatorMap.get(operator).operate(preArgument, Integer.parseInt(postArgument));
    }

    String[] parse(String input) {
        return input.split(DELIMITER);
    }

    boolean isValidate(String[] input) {
        if (input == null || input.length == 0 || input.length % 2 == 0 || !isNumber(input[0])) return INVALID;
        return VALID;
    }

    boolean isValidateOperator(String operator, String number) {
        if (!operatorMap.containsKey(operator) || !isNumber(number)) return INVALID;
        return VALID;
    }

    boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return INVALID;
        }
        return VALID;
    }

}
