package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calc {
    private final List<Integer> nums;

    public Calc(String str) {
        this.nums = prepareElements(str);
    }

    public static List<Integer> prepareElements(String str) {
        if (isBlank(str)) return Arrays.asList(0);
        String[] strings = getStrings(str);
        return parseInt(strings);
    }

    private static List<Integer> parseInt(String[] strings) {
        return Arrays.stream(strings).map(Calc::getInt).collect(Collectors.toList());
    }

    private static int getInt(String s) {
        int i = Integer.parseInt(s);
        if (i < 0) throw new RuntimeException();
        return i;
    }

    private static String[] getStrings(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find())
            return m.group(2).split(m.group(1));

        return str.split(",|:");
    }

    private static boolean isBlank(String str) {
        return str == null || str.isEmpty();
    }

    public int resultSum() {
        return sum(nums);
    }

    public static int sum(List<Integer> nums) {
        int result = 0;
        for (Integer num : nums)
            result += num;

        return result;
    }
}
