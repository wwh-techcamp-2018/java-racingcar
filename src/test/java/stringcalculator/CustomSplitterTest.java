package stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomSplitterTest {

    CustomSplitter customSplitter;

    @Before
    public void setup() {
        customSplitter = new CustomSplitter("1,2,3");
    }

    @Test
    public void supports() {
        customSplitter.setEquation("//;\n1;2;3");
        assertEquals(true, customSplitter.supports());
        customSplitter.setEquation("//;\n1;2;3;c");
        assertEquals(false, customSplitter.supports());
        customSplitter.setEquation("//*\n1*2*3");
        assertEquals(true, customSplitter.supports());
        customSplitter.setEquation("//*\n1*2*3");
        assertEquals(true, customSplitter.supports());
    }

    @Test
    public void split() {
        String[] s = {"1","2","3"};
        customSplitter.setEquation("//*\n1*2*3");
        assertArrayEquals(s , customSplitter.split());

    }

}