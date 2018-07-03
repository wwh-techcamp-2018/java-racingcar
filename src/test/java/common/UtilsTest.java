package common;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void dashTest() {
        assertEquals("---", Utils.dashString(3));
    }
}