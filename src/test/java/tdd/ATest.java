package tdd;

import calculator.tdd.CustomSplitter;
import calculator.tdd.DefaultSplitter;
import calculator.tdd.StringAdder;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ATest {
    StringAdder stringAdder;
    DefaultSplitter splitter;
    @Before
    public void setUp(){
         stringAdder = new StringAdder();
         splitter = new DefaultSplitter();
    }
    /*
    @Test
    public void split(){
        String input = "1,2";
        assertTrue(Arrays.equals(new String[]{"1", "2"},stringAdder.splitInput(input)));
    }
    */


    /*
    @Test
    public void splitBoth() {
        String input = "1,2:3";
        assertTrue(Arrays.equals(new String[]{"1", "2", "3"}, stringAdder.splitInput(input)));
    }
    */

    @Test
    public void adder() {
        String input = "1,2:3";
        assertEquals(6, stringAdder.run(input));
    }

    @Test
    public void adder빈문자열(){
        String input = "";
        assertEquals(0, stringAdder.run(input));
    }

    @Test
    public void adder널문자열(){
        String input = null;
        assertEquals(0, stringAdder.run(input));
    }
    @Test
    public void adder문자열길이1(){
        String input = "1";
        assertEquals(1, stringAdder.run(input));
    }
    @Test
    public void split구분자다음문자(){
        String input = "//!\n1,2!3";
        assertEquals("1,2!3", stringAdder.formatNumberStr(input));
    }
//    @Test
//    public void split구분자겟(){
//        String input = "//!\n1,2!3";
//        assertEquals("!", stringAdder.getSplitter(input));
//    }
//    @Test
//    public void split구분자없을때(){
//        String input = "1,2!3";
//        assertEquals(null, stringAdder.getSplitter(input));
//    }
    @Test
    public void split구분자없을때(){
        String input = "1,2!3";
        assertEquals("1,2!3", stringAdder.formatNumberStr(input));
    }
    @Test
    public void split구분자있을때(){
        String input = "//!\n1,2!3";
        assertEquals("1,2!3", stringAdder.formatNumberStr(input));
    }

    /*
    @Test
    public void 사용자구분자가숫자일때(){
        String numStr = "1";
        assertTrue(stringAdder.inValidateSplitter(numStr));
    }
    */

    @Test (expected = IllegalArgumentException.class)
    public void 사용자구분자가숫자일때Exception(){
        stringAdder.formatNumberStr("//3\n1");
    }

    /*
    @Test
    public void 사용자구분자가유효할때(){
        String splitter = "!";
        assertFalse(stringAdder.inValidateSplitter(splitter));
    }
    */


    @Test
    public void testMatcher(){

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("asbcd");
        if (m.find()) {
            String customDelimiter = m.group(1);
            System.out.print(customDelimiter);

        }
    }

    @Test
    public void defualtSplitterSupport(){

        String input = "1,2;3";
        assertTrue(splitter.unSupports(input));
    }

    @Test
    public void defaultSplitterSplit(){
        String input = "1,2,3";
        assertArrayEquals(new String[]{"1", "2", "3"}, splitter.split(input));
    }
    @Test (expected = IllegalArgumentException.class)
    public void unSupportCheck(){
        String input = "//!\n-1,2,3";
        stringAdder.run(input);

    }

    @Test
    public void createSingleCustomSplitter(){
        String splitter = "!";
        CustomSplitter sp = new CustomSplitter(splitter);
        assertArrayEquals(new String[]{"1", "2", "2223"},
                sp.split("1!2!2223"));
    }
    @Test
    public void createMultipleCustomSplitter() {
        List<String> splitter = Arrays.asList("!", "#");
        CustomSplitter sp = new CustomSplitter(splitter);
        assertArrayEquals(new String[]{"1", "2", "2223"},
                sp.split("1!2#2223"));
    }

    @Test
    public void 정상적인inputDefault테스트(){
        assertEquals(6, stringAdder.run("1:2,3"));
    }

    @Test
    public void 정상적인inputCustom테스트(){
        assertEquals(6, stringAdder.run("//!\n1!2!3"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void 비정상적인inputCustom테스트(){
        assertEquals(6, stringAdder.run("//!\n1,2!3"));
    }

}
