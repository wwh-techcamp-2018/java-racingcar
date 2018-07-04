package sum;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringParserTest {
    StringParser emptyParser;
    StringParser nullParser;
    StringParser defaultStringParser;
    StringParser customDelimiterStringParser;
    StringParser customParser;
    StringParser oneStringParser;
    StringParser notNumberStringParser;
    StringParser negativeNumberStringParser;

    @Before
    public void setUp() throws Exception {
        emptyParser = new StringParser("");
        nullParser = new StringParser(null);
        defaultStringParser = new StringParser("11:2,3");
        customDelimiterStringParser = new StringParser("11;2;3");
        customParser = new StringParser("//;\n1;2;3");
        oneStringParser = new StringParser("1");
        notNumberStringParser = new StringParser("a, 2, 3");
        negativeNumberStringParser = new StringParser("-1, 2, 3");
    }

    @Test
    public void generateZeroNumber() {
        assertThat(emptyParser.generateNumber())
                .contains(0);
        assertThat(nullParser.generateNumber())
                .contains(0);
    }

    @Test
    public void splitStringWithDefaultDelimiter() {
        String[] stringArray = defaultStringParser.splitString(StringParser.DEFAULT_DELIMITER);
        assertThat(stringArray).containsSequence("11", "2", "3");
    }

    @Test
    public void splitStringWithCustomDelimiter() {
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
        assertThat(oneStringParser.generateNumber())
                .contains(1);
    }

    @Test(expected = RuntimeException.class)
    public void generateNumberThrowExceptionWhenNotNumber() {
        notNumberStringParser.generateNumber();
    }

    @Test(expected = RuntimeException.class)
    public void generateNumberThrowExceptionWhenNegativeNumber() {
        negativeNumberStringParser.generateNumber();
    }

    @Test
    public void extractDelimiter() {
        assertThat(customParser.extractDelimeter()).isEqualTo(";");
    }
}
