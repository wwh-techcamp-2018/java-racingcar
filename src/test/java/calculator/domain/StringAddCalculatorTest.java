package calculator.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringAddCalculatorTest {
    private StringAddCalculator cal;

    @Before
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void nonCustomSplit() throws Exception {
        String text = "1,2";
        String[] tests = new String[]{"1","2"};
        assertEquals(tests[0], cal.nonCustomSplit(text,",")[0]);
        assertEquals(tests[1], cal.nonCustomSplit(text,",")[1]);
    }
    @Test
    public void nonCustomSplitWhenBlank() throws Exception {
        String text = "";
        assertEquals("0", cal.nonCustomSplit(text,",")[0]);
    }

    @Test
    public void customSplit() throws Exception {
        String text = "//;\n1;2";
        String[] tests = new String[]{"1","2"};
        assertEquals(tests[0], cal.customSplit(text)[0]);
        assertEquals(tests[1], cal.customSplit(text)[1]);
    }

    @Test
    public void customSplitWhenBlank() throws Exception {
        String text = "//\n";
        assertEquals("0", cal.customSplit(text)[0]);
    }

    @Test
    public void add() throws Exception {
        String text = "1,2";
        assertEquals(3, cal.add(cal.nonCustomSplit(text, ",")));

         text = "//;\n1;2";
        assertEquals(3, cal.add(cal.customSplit(text)));
    }
}