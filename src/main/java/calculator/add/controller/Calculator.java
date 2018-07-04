package calculator.add.controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public boolean checkException(String input) {
        return (input == null || input.trim().isEmpty());
    }

    public String[] getNumbers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    public int calculate(String[] numbers) {
        if (checkException(numbers[0])) return 0;
        int sum = 0;
        for (String number : numbers) {
            checkMinus(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    public void checkMinus(String number) {
        if (Integer.parseInt(number) < 0) throw new RuntimeException();
    }
}