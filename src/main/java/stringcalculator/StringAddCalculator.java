package stringcalculator;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {
    private static final int DEFAULT_INDEX = 0;
    private static final int CUSTOM_INDEX = 1;

    private List<Split> splits = Arrays.asList(new DefaultSplit(), new CustomSplit());
    private Positive positive = new Positive();

    private Split lookupSplitByInput(String input) {
        if (CalculatorUtil.isCustomSplit(input))
            return splits.get(CUSTOM_INDEX);
        return splits.get(DEFAULT_INDEX);
    }

    int add(String text){
        int result = 0;
        String[] values = excuteSplit(text);
        for (String value : values) {
            result += positive.convertPositiveInt(value);
        }
        return result;
    }

    private String[] excuteSplit(String text){
        Split split = lookupSplitByInput(text);
        return split.split(text);
    }
}
