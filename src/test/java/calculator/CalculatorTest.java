package calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    // Test methods 는 의존관계가 없기 때문에 랜덤으로 실행된다.
    // 실행 순서는 setUp -> Test method1  -> setUp -> Test method2 -> ...
    // Test methods 간의 독립성을 위하여 setUp도 매번 새로 실행
    @Test
    public void plusTest() {
        double d = Math.sqrt(1);
        assertEquals(5,cal.plus(2,3));
    }
    @Test
    public void missionTest(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int number = scanner.nextInt();
        assertEquals(11,cal.cal("2 + 3 * 4 / 2"));
    }
}