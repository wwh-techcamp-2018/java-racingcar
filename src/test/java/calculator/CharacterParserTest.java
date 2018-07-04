package calculator;

import calculator.parser.CharacterParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CharacterParserTest {

    private CharacterParser parser;
    private List<String> parsedList;

    @Before
    public void setUp() {
        parser = new CharacterParser();
        parsedList = new ArrayList<>();
    }

    @Test
    public void parseTest() {
        parsedList = parser.parse("1;2,3");
        assertThat(parsedList).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void parseCustomDelimiterTest() {
        parsedList = parser.parse("//@\n2@3");
        assertThat(parsedList).isEqualTo(Arrays.asList("2", "3"));
    }

    @Test
    public void parseEmptyTest() {
        parsedList = parser.parse("");
        assertThat(parsedList).isEqualTo(Arrays.asList("0"));
    }

    @Test
    public void parseNullTest() {
        parsedList = parser.parse(null);
        assertThat(parsedList).isEqualTo(Arrays.asList("0"));
    }

    @Test
    public void findCustomDelimiterTest() {
        assertThat(parser.findCustomDelimiter("//@\n2@3")).isEqualTo(true);
    }

    @Test
    public void notFoundCustomDelimiterTest() {
        assertThat(parser.findCustomDelimiter("2,3")).isEqualTo(false);
    }


    @Test
    public void changeDelimiterTest() {
        assertThat(parser.changeDelimiter("//@\n2@3")).isEqualTo("@");
    }

    @Test
    public void removeCustomDelimiterTest() {
        assertThat(parser.removeCustomDelimiter("//@\n2@3")).isEqualTo("2@3");
    }

    @Test
    public void extractOperatorsTest() {
        List<String> operators = parser.extractOperators(Arrays.asList("2", "3", "4"));
        assertThat(operators).isEqualTo(Arrays.asList("+", "+"));
    }

    @Test
    public void extractOperandsTest() {
        List<Integer> operands = parser.extractOperands(Arrays.asList("2", "3", "4"));
        assertThat(operands).isEqualTo(Arrays.asList(2, 3, 4));
    }

    @Test(expected = RuntimeException.class)
    public void checkNegativeNumericList() {
        parser.extractOperands(Arrays.asList("2", "-3", "4"));
    }

    @Test(expected = RuntimeException.class)
    public void checkNegativeNumeric() {
        parser.findNegativeNumeric(-2);
    }

    @Test
    public void splitDelimiter() {
        assertThat("2,4;1".split(",|;")).isEqualTo(new String[]{"2", "4", "1"});
    }

}