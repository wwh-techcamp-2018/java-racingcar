package calculator.string.adder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSpliter implements Spliter {
    public List<Integer> extractNums(String s){
        if (s == null || s.isEmpty()){
            return Arrays.asList(0);
        }
        List<Integer> list = Arrays.stream(s.split(",|:"))
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
