package stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultSplitterTest {


    DefaultSplitter defaultSplitter;

    @Before
    public void setup() {
        defaultSplitter = new DefaultSplitter("a,3");
    }

    @Test
    public void supports() {
        defaultSplitter.setEquation("a,3");
        assertEquals(false, defaultSplitter.supports());
        defaultSplitter.setEquation("1,3");
        assertEquals(true, defaultSplitter.supports());
    }

    @Test
    public void split() {
        String[] s = {"1","2","3"};
        defaultSplitter.setEquation(("1:2,3"));
        assertArrayEquals(s , defaultSplitter.split());

    }


}