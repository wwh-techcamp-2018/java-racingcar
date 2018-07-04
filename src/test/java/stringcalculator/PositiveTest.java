package stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositiveTest {

    Positive positive;

    @Before
    public void setup() {
        positive = new Positive();
    }

    @Test
    public void positiveConvertTest() {
        assertEquals(33, positive.convertPositiveInt("33"));
    }

    @Test(expected = RuntimeException.class)
    public void invalidInputTest() {
        positive.convertPositiveInt("#3");
    }

    @Test(expected = RuntimeException.class)
    public void minusInputText() {
        positive.convertPositiveInt("-1");
    }
}