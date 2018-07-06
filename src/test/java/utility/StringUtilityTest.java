package utility;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringUtilityTest {

    @Test
    public void repeatDash() {
        assertEquals("---", StringUtility.repeatDash(3));
    }

    @Test
    public void splitWithComma() {
        List<String> expected = Arrays.asList("a", "b");
        List<String> actual = Arrays.asList(StringUtility.splitWithComma("a,b"));
        assertThat(expected, is(actual));
    }

    @Test
    public void joinWithComma() {
        String actual = StringUtility.joinWithComma(Arrays.asList("a", "b"));
        assertEquals("a, b", actual);
    }

}