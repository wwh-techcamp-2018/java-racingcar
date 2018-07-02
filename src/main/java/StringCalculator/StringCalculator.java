package StringCalculator;

import calculator.Calculator;

public class StringCalculator {


    int calculate(String input){

        validate(input);

        String[] inputs = parse(input);

        int result = Integer.parseInt(inputs[0]);

        for(int i = 1; i < inputs.length - 1; i += 2){

            String operator = inputs[i];

            int nextValue = Integer.parseInt(inputs[i+1]);

            result = calculate(result, operator, nextValue);
        }

    }

    int calculate(int tempValue, String operator, int nextValue){

        Calculator calculator = new Calculator();

        if(operator.equals("+"))
            return calculator.plus(tempValue, nextValue);

        if(operator.equals("-"))
            return calculator.minus(tempValue, nextValue);

        if(operator.equals("*"))
            return calculator.multiply(tempValue, nextValue);

        if(operator.equals("/"))
            return calculator.divide(tempValue, nextValue);

    }


    String[] parse(String input){
        return input.split(" ");
    }



}
