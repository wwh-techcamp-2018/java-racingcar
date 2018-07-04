package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    /**
     * Todo
     * 빈 문자열 전달
     * 숫자 2개 전달
     * 숫자 3개 전달
     * 커스텀 구분자 문자열
     * 숫자 이외의 값 전달
     * 음수값 전달
     * <p>
     * Done
     * 쉼표 또는 콜론을 가지는 문자열이 들어왔을 때 숫자 반환
     */
    @Test
    public void 빈문자열() {
        assertThat(StringCalculator.getSum(" ")).isEqualTo(0);
    }

    @Test
    public void 쉼표_또는_콜론_숫자2개_문자열() {
        assertThat(StringCalculator.getSum("1,2")).isEqualTo(3);
    }

    @Test
    public void 쉼표_또는_콜론_숫자3개_문자열() {
        assertThat(StringCalculator.getSum("1,2:3")).isEqualTo(6);
    }

    @Test
    public void 커스텀구분자_문자열() {
        assertThat(StringCalculator.getSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 숫자이외의값_문자열() {
        int numbers = StringCalculator.getSum("*,2:3");
    }

    @Test(expected = RuntimeException.class)
    public void 음수포함_문자열() {
        int numbers = StringCalculator.getSum("-2,2:3");
    }
}
