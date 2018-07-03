package utility;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilityTest {
    @Test
    public void repeatDash() {
        assertEquals("---", StringUtility.repeatDash(3));
    }
}