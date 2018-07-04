package calculator;

import calculator.parser.CharacterParser;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator characterCalculator;
    private Calculator spaceCalculator;

    @Before
    public void setUp() {
        characterCalculator = new Calculator(new CharacterParser());
        spaceCalculator = new Calculator(new SpaceParser());
    }

    @Test
    public void calculateCharacterParser() {
        new Calculator(new CharacterParser());
        assertThat(characterCalculator.calculate("2,3,4")).isEqualTo(9);
    }

    @Test
    public void operatePlus() {
        assertEquals(5, characterCalculator.operate("+", 2, 3));
        assertEquals(5, spaceCalculator.operate("+", 2, 3));
    }

    @Test
    public void operateMinus() {
        assertThat(spaceCalculator.operate("-", 2, 3)).isEqualTo(-1);
    }

    @Test
    public void operateMultiply() {
        assertThat(spaceCalculator.operate("*", 2, 3)).isEqualTo(6);
    }

    @Test
    public void operateDivide() {
        assertThat(spaceCalculator.operate("/", 4, 2)).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void operateDivideByZero() {
        spaceCalculator.operate("/", 4, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void operateInvalidOperator() {
        spaceCalculator.operate("!", 2, 3);
    }

}