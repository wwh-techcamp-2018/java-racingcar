package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator cal;
    //Test 어노테이션만 붙이면 얘를 테스트케이스로 인식한다.


    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    @Test
    public void plus() {
        int result = cal.plus(2, 3);
        //JUnit에서는 눈으로 확인하는게 아니라 아래와 같은 메소드를 사용한다
        assertEquals(5, result);
        // 참고로 실행단축기 Control+Shift+R,expected와 다른값이라면 에러출력, 아니라면 정상종료
    }

    @Test
    public void minus() {
            assertEquals(-1, cal.minus(2, 3));//이렇게도 가능하다.
    }

}
/*
실행순서 :
1. Setup Method
2. Test 메소드 중 1개 , 테스트메소드끼리의 순서는 랜덤!!!
=> 테스트메소드끼리 의존성이 있으면 안된다. 100% 독립적이어야 함
3. Setup Method 다시실행
=> 독립성을 보장하기 위해서 이렇게 실행된다.
4. 다른 Test 메소드
 */


/*
@Test (expected = IllegalArgumentException.class)
 Alt + F12 : 인텔리j에서 깃명령어 바로입력
 */