package util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    @Test
    public void repeatTest() {
        assertEquals("-", StringUtil.repeatDash(1));
        assertEquals("---", StringUtil.repeatDash(3));
    }
}