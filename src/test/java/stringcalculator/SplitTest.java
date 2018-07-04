package stringcalculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SplitTest {

    List<String> testcase = Arrays.asList(
            "1:2",
            "1,2",
            "1,2:3",
            "",
            null
    );

    @Test
    public void defaultSplitTest() {
        DefaultSplit split = new DefaultSplit();


        assertArrayEquals(new String[]{"1", "2"}, split.splitInternal(testcase.get(0)));
        assertArrayEquals(new String[]{"1", "2"}, split.splitInternal(testcase.get(1)));
        assertArrayEquals(new String[]{"1", "2", "3"}, split.splitInternal(testcase.get(2)));

        assertArrayEquals(new String[]{"0"}, split.splitInternal(testcase.get(3)));
        assertArrayEquals(new String[]{"0"}, split.splitInternal(testcase.get(4)));
    }


    @Test
    public void customSplitTest() {
        CustomSplit split = new CustomSplit();
        split.split("//;\n1;3");
        assertEquals(";", split.getSpliter());
    }

    @Test
    public void matcherTest() {
        assertEquals(true, CalculatorUtil.isCustomSplit("//$\n"));
    }

    @Test
    public void matcherStudyTest() {
        String text = "//;\n1;3";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        m.find();
        assertEquals(";", m.group(1));
    }
}