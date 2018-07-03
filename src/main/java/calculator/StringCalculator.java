package calculator;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class StringCalculator {

    private Stack<String> operators = new Stack<String>();
    private Stack<Integer> numbers = new Stack<Integer>();

    private void initStack() {
        operators.clear();
        numbers.clear();
    }

    public int stringCalculator(String text) {
        initStack();
        nullCheckOfInput(text);
        String[] simbols = text.split(" ");
        for (int i = 0; i < simbols.length; i++) {
            simbolProcessing(simbols[i]);
        }
        stackStateCheck();
        return numbers.pop();
    }

    private void nullCheckOfInput(String input) {
        if (input == null || "".equals(input))
            throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
    }

    private void simbolProcessing(String simbol) {
        if (isNumber(simbol))
            numbers.push(Integer.valueOf(simbol));
        if (!isNumber((simbol)))
            operators.push(simbol);

        if (numbers.size() == 2) {
            numbers.push(calculatorProcess());
        }
    }

    private int calculatorProcess() {
        try {
            String operation = operators.pop();
            return calculate(operation, numbers.pop(), numbers.pop());

        } catch (EmptyStackException | IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
        }
    }

    private int calculate(String operation, int num1, int num2) {
        switch (operation) {
            case "+":
                return num1 + num1;
            case "-":
                return num1 - num1;
            case "*":
                return num1 * num1;
            case "/":
                return num1 / num1;
            default:
                throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
        }
    }

    private void stackStateCheck() {
        if (operators.size() != 0)
            throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
        if (numbers.size() != 1)
            throw new IllegalArgumentException("잘못된 수식을 입력했습니다.");
    }


    public boolean isNumber(String simbol) {
        try {
            Integer.parseInt(simbol);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}