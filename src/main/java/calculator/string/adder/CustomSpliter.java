package calculator.string.adder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomSpliter implements Spliter {
    private String delimiter;

    public CustomSpliter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<Integer> extractNums(String s) {
        Matcher m = Pattern.compile("//(.)N(.*)").matcher(s);
        if (m.find()) {
            String customDelimiter = m.group(1);
            s = m.group(2);
        }
        if (s == null || s.isEmpty()){
            return Arrays.asList(0);
        }

        List<Integer> list = Arrays.stream(s.split(this.delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (Integer integer : list) {
            if (integer < 0) {
                throw new RuntimeException();
            }
        }
        return list;
    }
}
