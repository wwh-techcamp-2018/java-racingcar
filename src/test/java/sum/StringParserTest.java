package sum;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringParserTest {
    StringParser customParser;

    @Before
    public void setUp() throws Exception {
        customParser = new StringParser("//;\n1;2;3");
    }

    @Test
    public void generateZeroNumber() {
        StringParser emptyParser = new StringParser("");
        StringParser nullParser = new StringParser(null);
        assertThat(emptyParser.generateNumber())
                .contains(0);
        assertThat(nullParser.generateNumber())
                .contains(0);
    }

    @Test
    public void splitStringWithDefaultDelimiter() {
        StringParser defaultStringParser = new StringParser("11:2,3");
        String[] stringArray = defaultStringParser.splitString(StringParser.DEFAULT_DELIMITER);
        assertThat(stringArray).containsSequence("11", "2", "3");
    }

    @Test
    public void splitStringWithCustomDelimiter() {
        StringParser customDelimiterStringParser = new StringParser("11;2;3");
        String[] stringArray = customDelimiterStringParser.splitString(";");
        assertThat(stringArray).contains("11")
                .contains("2")
                .contains("3");
    }

    @Test
    public void generateNumberWithCustomDelimiter() {
        int[] intArray = customParser.generateNumber();
        assertThat(intArray).contains(1)
                .contains(2)
                .contains(3);
    }

    @Test
    public void generateOneNumber() {
        StringParser oneStringParser = new StringParser("1");
        assertThat(oneStringParser.generateNumber())
                .contains(1);
    }

    @Test(expected = RuntimeException.class)
    public void generateNumberThrowExceptionWhenNotNumber() {
        StringParser notNumberStringParser = new StringParser("a, 2, 3");
        notNumberStringParser.generateNumber();
    }

    @Test(expected = RuntimeException.class)
    public void generateNumberThrowExceptionWhenNegativeNumber() {
        StringParser negativeNumberStringParser = new StringParser("-1, 2, 3");
        negativeNumberStringParser.generateNumber();
    }

    @Test
    public void extractDelimiter() {
        assertThat(customParser.extractDelimiter()).isEqualTo(";");
    }
}
