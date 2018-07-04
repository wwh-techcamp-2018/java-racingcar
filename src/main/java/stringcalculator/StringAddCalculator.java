package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    Scanner scanner = new Scanner(System.in);

    private List<Positive> numbers;
    private Splitter splitter;
    private Positive sum;

    String getMathExpression() {
        String value = scanner.nextLine();
        return value;
    }

    private List<Positive> getValidNumbers(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        splitter = getMatchingSplitter(m.find(), input);
        if(splitter.supports()) {
            return getValidNumberList(splitter.split());
        }
        return null;
    }

    private Splitter getMatchingSplitter(boolean threshold, String input) {
        if(threshold) {
            return new CustomSplitter(input);
        }
        return new DefaultSplitter(input);
    }

    private List<Positive> getValidNumberList(String[] strings) {
        List<Positive> positiveList = new ArrayList<>();
        for (String s : strings) {
            positiveList.add(new Positive(s));
        }
        return positiveList;
    }

    private List<Positive> getNumbers(String input) {
        List<Positive> results;
        if(input == null || input.isEmpty()) {
            results = new ArrayList<>();
            results.add(new Positive());
            return results;
        }
        return getValidNumbers(input);
    }

    public int add(String s) {
        sum = new Positive();
        numbers = getNumbers(s);
        for (Positive number : numbers) {
            sum = sum.add(number);
        }
        return sum.getValue();
    }

    public void run() {
        String input = getMathExpression();
        System.out.println(add(input));
    }


}
