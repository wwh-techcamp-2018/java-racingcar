package calculator;

import calculator.common.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static String[] findDelimeter(String text) {
        Matcher m = Pattern.compile("//(.)/n(.*)").matcher(text);
        if (m.find()) {
            return new String[] {m.group(1), m.group(2)};
        }
        return new String[] {",|:", text};
    }

    public static int[] split(String[] delimTextPair) {
        String[] tokens = delimTextPair[1].split(delimTextPair[0]);
        return convertToInt(tokens);
    }

    public static int[] convertToInt(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < numbers.length; i++) {
            try {
                numbers[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw new RuntimeException();
            }
            if (numbers[i] < 0) {
                throw new RuntimeException();
            }
        }
        return numbers;
    }

    public static int add(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int run(String text) {
        if(StringUtils.notEmptyInput(text)) {
            return add(split(findDelimeter(text)));
        }
        return 0;
    }

}