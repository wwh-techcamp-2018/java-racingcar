package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int getSum(String inputText) {
        if (isEmpty(inputText)) {
            return 0;
        }
        return getSum(toInts(split(inputText)));
    }

    private static boolean isEmpty(String inputText) {
        return inputText.trim().isEmpty();

    }

    private static int getSum(int[] intArr) {
        return Arrays.stream(intArr).sum();
    }

    private static int[] toInts(String[] inputText) {
        int[] intArr = new int[inputText.length];
        for (int i = 0; i < inputText.length; i++) {
            intArr[i] = Integer.parseInt(inputText[i]);
            checkMinus(intArr[i]);
        }
        return intArr;
    }

    private static void checkMinus(int number) {
        if (number < 0)
            throw new RuntimeException();
    }

    private static String[] split(String inputText) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return inputText.split(",|:");
    }

}
