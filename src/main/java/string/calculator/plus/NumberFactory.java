package string.calculator.plus;

import java.util.ArrayList;
import java.util.List;

public class NumberFactory {

    public static List<Integer> getNumbers(String inputString) {
        return getNumbers(inputString, ",|:");
    }

    private static List<Integer> splitIntegers(String[] splitNumbers) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String splitNumber : splitNumbers) {
            numbers.add(isInteger(splitNumber));
        }
        return numbers;
    }

    public static List<Integer> getNumbers(String inputString, String delimeter) {
        String[] splitNumbers = inputString.split(delimeter);
        List<Integer> numbers = splitIntegers(splitNumbers);
        return numbers;
    }

    public static int plusNumbers(List<Integer> numbers) {
        int resultNumber = 0;
        for (Integer number : numbers) {
            resultNumber += number;
        }
        return resultNumber;
    }

    public static int isInteger(String string) {
        int returnNumber = 0;
        try {
            return isPositiveNumber(Integer.parseInt(string));
        } catch (IllegalAccessError error) {
            throw new RuntimeException();
        }
    }

    public static int isPositiveNumber(int number) {
        if (number > 0) {
            return number;
        }
        throw new RuntimeException();
    }
}
