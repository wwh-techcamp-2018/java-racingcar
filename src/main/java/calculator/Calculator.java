package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    StringParser stringParser = new StringParser();
    Map<String, CalculateStrategy> operateMap = new HashMap();

    public Calculator (String inputText) {
        operateMap.put("+", (a, b) -> a+b);
        operateMap.put("-", (a, b) -> a-b);
        operateMap.put("*", (a, b) -> a*b);
        operateMap.put("/", (a, b) -> a/b);
        stringParser.setInput(inputText);
    }
    public int getCalculate(String operator, int a, int b) {
        return operateMap.get(operator).calculate(a, b);
    }

    public int continuousCalculation() {
        int a, b;
        String operator;
        a = stringParser.nextNum();

        int operatorCount = stringParser.getOperatorCount();

        for (int i = 0; i < operatorCount; i++) {
            operator = stringParser.nextOperator();
            b = stringParser.nextNum();

            a = getCalculate(operator, a, b);
        }

        return a;
    }

}
